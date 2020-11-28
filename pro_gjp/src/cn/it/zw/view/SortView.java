package cn.it.zw.view;


import cn.it.zw.bean.ZhangWu;
import cn.it.zw.service.ZhangWuService;
import cn.it.zw.service.ZhangWuServiceImpl;

import java.util.List;
import java.util.Scanner;

public class SortView {
    static ZhangWuService zhangWuService = new ZhangWuServiceImpl();
    static ZhangWu zhangWu = new ZhangWu();

    //按照标题排序
    public static void SortBytitle() {
        boolean flag1 = true;
        int page = 0;
        int i = 1;   //用于++序号的
        boolean run = true;
        while (flag1) {
            List<ZhangWu> everypage = zhangWuService.queryAll();     //everypage求出所有的记录条数
            int pagesize;
            if (everypage.size() % 5 == 0) {
                pagesize = everypage.size() / 5;
            } else {
                pagesize = everypage.size() / 5 + 1;
            }
            List<ZhangWu> everypagea = zhangWuService.sortBytitle(zhangWu,page);
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


    //按照时间排序
    public static void SortBydata() {
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
            List<ZhangWu> everypagea = zhangWuService.sortBydata(zhangWu,page);
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

        //按照用户排序
        public static void SortByuser () {

            boolean flag1 = true;
            int page = 0;
            int i = 1;   //用于++序号的
            boolean run = true;

            while (flag1) {
                List<ZhangWu> everypage = zhangWuService.queryAll();     //everypage求出所有的记录条数
                int pagesize;
                if (everypage.size() % 5 == 0) {
                    pagesize = everypage.size() / 5;
                } else {
                    pagesize = everypage.size() / 5 + 1;
                }
                //page为0,5,10
                List<ZhangWu> everypagea = zhangWuService.sortByuser(zhangWu,page);
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

            //按照金额排序
            public static void SortByprice() {

                boolean flag1 = true;
                int page = 0;
                int i = 1;   //用于++序号的
                boolean run = true;

                while (flag1) {
                    List<ZhangWu> everypage = zhangWuService.queryAll();     //everypage求出所有的记录条数
                    int pagesize;
                    if (everypage.size() % 5 == 0) {
                        pagesize = everypage.size() / 5;
                    } else {
                        pagesize = everypage.size() / 5 + 1;
                    }
                    //page为0,5,10
                    List<ZhangWu> everypagea = zhangWuService.sortByprice(zhangWu,page);
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
