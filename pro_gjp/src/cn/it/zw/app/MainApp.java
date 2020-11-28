package cn.it.zw.app;

import cn.it.zw.view.MainView;

/**
 * 编写main主方法，用来完成本项目的启动
 */
public class MainApp {
    public static void main(String[] args) {
        start();
    }

    // 主菜单控制
    public static void start(){
        MainView.mainView();
    }
}
