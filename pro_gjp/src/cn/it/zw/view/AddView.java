package cn.it.zw.view;

import cn.it.zw.bean.Time;
import cn.it.zw.bean.ZhangWu;
import cn.it.zw.controller.ZhangWuController;
import cn.it.zw.service.ZhangWuService;
import cn.it.zw.service.ZhangWuServiceImpl;
import cn.it.zw.tools.Regex;

import java.util.List;
import java.util.Scanner;

public class AddView {
    static Scanner scanner = new Scanner(System.in);
    private static ZhangWuController zhangWuController = new ZhangWuController();
    static ZhangWu zhangWu = new ZhangWu();

    public static void addView() {

        Regex regex = new Regex();
        boolean zhengze = true;
        do {
            System.out.println("请输入用户名：");
            String user = scanner.next();
            if (user.matches(regex.userRegex())){
                zhangWu.setUser(user);
                zhengze = false;
            }else {
                System.out.println("输入格式有误");
                zhengze = true;
            }
        }while (zhengze);

        do {
            System.out.println("请输入日期：");
            String bill_time = scanner.next();
            if (bill_time.matches(regex.dateRegex())){
                zhangWu.setBill_time(bill_time);
                zhengze = false;
            }else {
                System.out.println("输入格式有误");
                zhengze = true;
            }
        }while (zhengze);

        do {
            System.out.println("请选择账目类型：1.支出  2.收入  3.借出  4.还入  5.借入  6.还出  7.不限");
            Integer type_id = scanner.nextInt();
            zhangWu.setType_id(type_id);
            switch (type_id){
                case 1:
                    String s1 = "支出";
                    zhangWu.setName(s1);
                    zhengze = false;
                    break;
                case 2:
                    String s2 = "收入";
                    zhangWu.setName(s2);
                    zhengze = false;
                    break;
                case 3:
                    String s3 = "借出";
                    zhangWu.setName(s3);
                    zhengze = false;
                    break;
                case 4:
                    String s4 = "还入";
                    zhangWu.setName(s4);
                    zhengze = false;
                    break;
                case 5:
                    String s5 = "借入";
                    zhangWu.setName(s5);
                    zhengze = false;
                    break;
                case 6:
                    String s6 = "还出";
                    zhangWu.setName(s6);
                    zhengze = false;
                    break;
                case 7:
                    String s7 = "不限";
                    zhangWu.setName(s7);
                    zhengze = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    zhengze = true;
                    break;
            }
        }while (zhengze);

        do {
            System.out.println("请输入金额：");
            String price = scanner.next();
            if (price.matches(regex.priceRegex())){
                zhangWu.setPrice(Integer.valueOf(price).intValue());
                zhengze = false;
            }else {
                System.out.println("输入格式有误");
                zhengze = true;
            }
        }while (zhengze);

        System.out.println("请输入标题：");
        String title = scanner.next();
        zhangWu.setTitle(title);
        System.out.println("请输入说明：");
        String explain = scanner.next();
        zhangWu.setExplain(explain);

        zhangWuController.add(zhangWu);
    }

    public static void addResultView(String result) {
        if (result.equals("success")){
            System.out.println("添加成功");
        }
    }

    //通过日期查看记录
    public static void queryAllBydata() {
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();
        Time time = new Time();
        System.out.println("请输入开始日期：");
        String kaishi = scanner.next();
        time.setStar_time(kaishi);
        System.out.println("请输入结束日期：");
        String jieshu = scanner.next();
        time.setEnd_time(jieshu);

        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;

        while (flag1) {
            //需要定义一个返回参数，即总条数
            List<ZhangWu> everypage = zhangWuService.queryZhangWuBydata(time);
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size() / 5;
            } else {
                pagesize = everypage.size() / 5 + 1;
            }
            List<ZhangWu> everypagea = zhangWuService.queryZhangWuBydata(time,page);
            if (run) {
                System.out.println("\t标题\t\t用户\t\t日期\t\t\t\t账户类型\t\t账目金额\t\t说明");
                for (ZhangWu z : everypagea
                ) {
                    System.out.println((i++) + "\t" + z.getTitle() + "\t\t" + z.getUser() + "\t\t" +
                            z.getBill_time() + "\t\t\t" + z.getName() + "\t\t" + z.getPrice() + "" +
                            "\t\t\t" + z.getExplain());
                }
                System.out.println("------------------------------------------------------------");
                System.out.println("共计" + pagesize + "页" + "\t" + "当前页为" + (((page) / 5) + 1) + "页\t" + "请输入\tW下一页\tS上一页\t0退出");
            }

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            boolean judge = true;
            while (judge) {
                if (input.equals("W")) {
                    if ((page / 5) + 1 == pagesize) {
                        System.out.println("当前为最后一页");
                        run = false;
                        judge = false;
                    } else {
                        page += 5;
                        judge = false;
                        run = true;
                    }
                } else if (input.equals("S")) {
                    if (page >= 5) {
                        int remainder = i % 5;
                        if ((i - 1) % 5 != 0) {
                            i = i - (4 + remainder);
                            page -= 5;
                            run = true;
                            judge = false;
                        } else {
                            page -= 5;
                            i -= 10;
                            run = true;
                            judge = false;
                        }
                    } else {
                        System.out.println("当前页码为第一页，没有上一页。");
                        run = false;
                        judge = false;
                    }
                } else if (input.equals("0")) {
                    judge = false;
                    flag1 = false;
                } else {
                    System.out.println("输入错误请重新输入");
                    input = scanner.next();
                }
            }
        }
    }

}
