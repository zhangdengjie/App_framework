package com.zdj.app.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zdj.app.R;
import com.zdj.app.common.net.AsyncHttpNetCenter;
import com.zdj.app.myApplication.AppManager;
import com.zdj.app.ui.helper.UIHelper;
import com.zdj.app.utils.StringUtils;

import butterknife.ButterKnife;

/**
 * 窗口基类
 * Created by dengjie on 2015/12/25.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected ProgressDialog mProgressDialog;
    protected FragmentManager fragmentManager;

    protected ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        initContentView();
        // 初始化View注入
        ButterKnife.bind(this);
        // 将该Activity加入堆栈
        AppManager.getAppManager().addActivity(this);
        initPresenter();
        initData();
        initView();
        initEvent();
        mActionBar = getSupportActionBar();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }
    }

    protected abstract void initEvent();
    protected abstract void initData();


    /**
     * 设置返回箭头的点击事件 <br/>
     * created at 2015/12/28 9:58
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 返回箭头的id为 android.R.id.home
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        // 清除网络请求队列
        AsyncHttpNetCenter.getInstance().clearRequestQueue(this);
//        OkHttpNetCenter.getInstance().clearRequestQueue(this);
        // 将该Activity从堆栈移除
        AppManager.getAppManager().removeActivity(this);
        super.onDestroy();
    }

    /**
     * 初始化布局 <br/>
     * created at 2015/12/25 17:53
     */
    protected abstract void initContentView();
    
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    /**
     * 初始化控制中心
     */
    public abstract void initPresenter();

    /**
     * 是否有返回按钮，默认没有 <br/>
     * created at 2015/12/28 9:30
     */
    protected boolean hasBackButton() {
        return false;
    }
    protected boolean hasActionBar() {
        return true;
    }


    protected void initActionBar(ActionBar actionBar) {
        if (actionBar == null)
            return;
        if (hasBackButton()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        } else {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            actionBar.setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }
        }
    }

    public void setActionBarTitle(int resId) {
        if (resId != 0) {
            setActionBarTitle(getString(resId));
        }
    }

    public void setActionBarTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            title = getString(R.string.app_name);
        }
        if (hasActionBar() && mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    /**
     * 初始化view的一些数据以及设置view相关操作 <br/>
     * created at 2015/12/25 16:31
     */
    protected abstract void initView();

    @Override
    public void showProgress(boolean flag, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(flag);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(message);
        }

        mProgressDialog.show();
    }

    @Override
    public void showProgress(String message) {
        showProgress(true, message);
    }

    @Override
    public void showProgress() {
        showProgress(true);
    }

    @Override
    public void showProgress(boolean flag) {
        showProgress(flag, "");
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog == null)
            return;

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(int resId) {
        UIHelper.showToast(this,getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            UIHelper.showToast(this, msg);
        }
    }

    @Override
    public void close() {
        finish();
    }

    /**
     * TODO 定义一些ActionBar上面的保护类方法，比如返回按钮、下拉事件等等; <br/>
     * created at 2015/12/25 16:32
     */
    
    /**
     * TODO 添加观察者模式的支持 <br/>
     * created at 2015/12/25 16:33
     */




}
