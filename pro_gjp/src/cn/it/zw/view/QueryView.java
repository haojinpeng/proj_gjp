package cn.it.zw.view;

import cn.it.zw.bean.ZhangWu;
import cn.it.zw.controller.ZhangWuController;
import cn.it.zw.service.ZhangWuService;
import cn.it.zw.service.ZhangWuServiceImpl;

import java.util.List;
import java.util.Scanner;

public class QueryView {
    static Scanner scanner = new Scanner(System.in);
    private static ZhangWuController zhangWuController = new ZhangWuController();
    static ZhangWu zhangWu = new ZhangWu();

    //按照类型查找
    public static void queryAllBytype(){
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();
        System.out.println("请选择类型：");
        System.out.println("1.支出  2.收入  3.借出  4.还入  5.借入  6.还出  7.不限");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                String s1 = "支出";
                zhangWu.setName(s1);
                break;
            case 2:
                String s2 = "收入";
                zhangWu.setName(s2);
                break;
            case 3:
                String s3 = "借出";
                zhangWu.setName(s3);
                break;
            case 4:
                String s4 = "还入";
                zhangWu.setName(s4);
                break;
            case 5:
                String s5 = "借入";
                zhangWu.setName(s5);
                break;
            case 6:
                String s6 = "还出";
                zhangWu.setName(s6);
                break;
            case 7:
                String s7 = "不限";
                zhangWu.setName(s7);
                break;
            default:
                break;
        }

        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;
        while (flag1) {
            List<ZhangWu> everypage = zhangWuService.queryZhangWuBytype(zhangWu);
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size()/5;
            } else {
                pagesize = everypage.size()/5 + 1;
            }
            //page为0,5,10
            List<ZhangWu> everypagea = zhangWuService.queryZhangWuBytype(zhangWu,page);
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
                        break;
                    } else {
                        page += 5;
                        judge = false;
                        run = true;
                        break;
                    }
                } else if (input.equals("S")) {
                    if (page >= 5) {
                        int remainder = i % 5;
                        if ((i - 1) % 5 != 0) {
                            i = i - (4 + remainder);
                            page -= 5;
                            run = true;
                            judge = false;
                            break;
                        } else {
                            page -= 5;
                            run = true;
                            judge = false;
                            i -= 10;
                            break;
                        }
                    } else {
                        System.out.println("当前页码为第一页，没有上一页。");
                        run = false;
                        judge = false;
                        break;
                    }
                } else if (input.equals("0")) {
                    judge = false;
                    flag1 = false;
                    break;
                } else {
                    System.out.println("输入错误请重新输入");
                    input = scanner.next();
                    break;
                }
            }
        }
    }

    //按照用户查找
    public static void queryAllByuser() {
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();
        System.out.println("请输入用户名，该功能支持模糊查询");
        String user = scanner.next();
        zhangWu.setUser(user);

        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;
        while (flag1) {
            List<ZhangWu> everypage = zhangWuService.queryZhangWuByuser(zhangWu);
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size()/5;
            } else {
                pagesize = everypage.size()/5 + 1;
            }
            //page为0,5,10
            List<ZhangWu> everypagea = zhangWuService.queryZhangWuByuser(zhangWu, page);
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
                        break;
                    } else {
                        page += 5;
                        judge = false;
                        run = true;
                        break;
                    }
                } else if (input.equals("S")) {
                    if (page >= 5) {
                        int remainder = i % 5;
                        if ((i - 1) % 5 != 0) {
                            i = i - (4 + remainder);
                            page -= 5;
                            run = true;
                            judge = false;
                            break;
                        } else {
                            page -= 5;
                            run = true;
                            judge = false;
                            i -= 10;
                            break;
                        }
                    } else {
                        System.out.println("当前页码为第一页，没有上一页。");
                        run = false;
                        judge = false;
                        break;
                    }
                } else if (input.equals("0")) {
                    judge = false;
                    flag1 = false;
                    break;
                } else {
                    System.out.println("输入错误请重新输入");
                    input = scanner.next();
                    break;
                }
            }
        }
    }

    //按照标题查找
    public static void queryAllBytitle(){
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();
        System.out.println("请输入标题名，该功能支持模糊查询：");
        String title = scanner.next();
        zhangWu.setTitle(title);

        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;
        while (flag1) {
            List<ZhangWu> everypage = zhangWuService.queryZhangWuBytitle(zhangWu);
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size() / 5;
            } else {
                pagesize = everypage.size() / 5 + 1;
            }
            //page为0,5,10
            List<ZhangWu> everypagea = zhangWuService.queryZhangWuBytitle(zhangWu, page);
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
                        break;
                    } else {
                        page += 5;
                        judge = false;
                        run = true;
                        break;
                    }
                } else if (input.equals("S")) {
                    if (page >= 5) {
                        int remainder = i % 5;
                        if ((i - 1) % 5 != 0) {
                            i = i - (4 + remainder);
                            page -= 5;
                            run = true;
                            judge = false;
                            break;
                        } else {
                            page -= 5;
                            run = true;
                            judge = false;
                            i -= 10;
                            break;
                        }
                    } else {
                        System.out.println("当前页码为第一页，没有上一页。");
                        run = false;
                        judge = false;
                        break;
                    }
                } else if (input.equals("0")) {
                    judge = false;
                    flag1 = false;
                    break;
                } else {
                    System.out.println("输入错误请重新输入");
                    input = scanner.next();
                    break;
                }
            }
        }

    }

    //查询所有
    public static void queryAll(){
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();
        List<ZhangWu> zhangWuList = zhangWuService.queryAll();
        System.out.println("\t标题\t\t用户\t\t日期\t\t\t\t账户类型\t\t账目金额\t\t说明");
        for (ZhangWu z:zhangWuList
        ) {
            int i =0;
            System.out.println((++i)+"\t"+z.getTitle()+"\t\t"+z.getUser()+"\t\t"+
                    z.getBill_time()+"\t\t\t"+z.getType_id()+"\t\t"+z.getPrice()+"" +
                    "\t\t\t"+z.getExplain());
        }
    }

    public static void queryZhangWuAll(){
        ZhangWuService zhangWuService = new ZhangWuServiceImpl();

        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;
        while (flag1) {
            //page为0,5,10
            List<ZhangWu> everypage = zhangWuService.queryAll();     //everypage求出所有的记录条数
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size() / 5;
            } else {
                pagesize = everypage.size() / 5 + 1;
            }



            List<ZhangWu> everypagea= zhangWuService.queryZhangWuAll(zhangWu,page);     //everypagea遍历
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
                        break;
                    } else {
                        page += 5;
                        judge = false;
                        run = true;
                        break;
                    }
                } else if (input.equals("S")) {
                    if (page >= 5) {
                        int remainder = i % 5;
                        if ((i - 1) % 5 != 0) {
                            i = i - (4 + remainder);
                            page -= 5;
                            run = true;
                            judge = false;
                            break;
                        } else {
                            page -= 5;
                            run = true;
                            judge = false;
                            i -= 10;
                            break;
                        }
                    } else {
                        System.out.println("当前页码为第一页，没有上一页。");
                        run = false;
                        judge = false;
                        break;
                    }
                } else if (input.equals("0")) {
                    judge = false;
                    flag1 = false;
                    break;
                } else {
                    System.out.println("输入错误请重新输入");
                    input = scanner.next();
                    break;
                }
            }
        }


    }
}
