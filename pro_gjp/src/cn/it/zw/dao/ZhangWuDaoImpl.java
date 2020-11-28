package cn.it.zw.dao;

import cn.it.zw.bean.Time;
import cn.it.zw.bean.ZhangWu;
import cn.it.zw.tools.JDBCPoolUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ZhangWuDaoImpl implements ZhangWuDao {
    QueryRunner queryRunner = new QueryRunner(JDBCPoolUtils.getDataSource());

    @Override
    public String addZhangWu(ZhangWu zhangWu) {

        //1.编写sql
        String sql = "insert into bills (bills.user,bills.title,bills.bill_time,bills.type_id,bills.price,bills.explain) values(?,?,?,?,?,?)";
        //2.打印sql
        System.out.println(sql);
        //3传入参数处理
        Object[] params = {zhangWu.getUser(), zhangWu.getTitle(), zhangWu.getBill_time(),zhangWu.getType_id() , zhangWu.getPrice(), zhangWu.getExplain()};
        //4.执行并返回结果
        try {
            int rows = queryRunner.update(sql, params);
            if (rows > 0) {
                return "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuBydata(Time time) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.bill_time BETWEEN ? AND ? \n" +
                "AND bs.type_id = bt.id";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {time.getStar_time(), time.getEnd_time()};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //通过日期查找
    @Override
    public List<ZhangWu> queryZhangWuBydata(Time time,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.bill_time BETWEEN ? AND ? \n" +
                "AND bs.type_id = bt.id limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {time.getStar_time(), time.getEnd_time(),index};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.user,bs.bill_time,ty.NAME,bs.price,bs.explain \n" +
                "FROM bill_type ty,bills bs\n" +
                "WHERE ty.id = bs.type_id\n" +
                "AND ty.name = ?";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getName()};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {

                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //通过类型查找
    @Override
    public List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.user,bs.bill_time,ty.NAME,bs.price,bs.explain \n" +
                "FROM bill_type ty,bills bs\n" +
                "WHERE ty.id = bs.type_id\n" +
                "AND ty.name = ?  limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getName(),index};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {

                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.USER LIKE \"%\"?\"%\" \n" +
                "AND bs.type_id = bt.id";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getUser()};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //按照用户查看记录
    @Override
    public List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.USER LIKE \"%\"?\"%\" \n" +
                "AND bs.type_id = bt.id limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getUser(),index};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.title LIKE \"%\"?\"%\"\n" +
                "AND bs.type_id = bt.id";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getTitle()};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.title LIKE \"%\"?\"%\"\n" +
                "AND bs.type_id = bt.id limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {zhangWu.getTitle(),index};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryZhangWuAll(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql ="SELECT bs.id,bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN \n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.type_id = bt.id limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        Object[] params = {index};
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> queryAll() {
        //1.编写sql
        String sql = "SELECT * FROM bills ";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数处理
        //4.执行
        try {
            List<ZhangWu> zhangWuList = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class));
            if (zhangWuList != null && zhangWuList.size() > 0) {
                return zhangWuList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void deleteZhangWu(Integer xuhao) {

        int xuhao1 = 0;
        int zhangwuId = 0;
        List<ZhangWu> zhangWuList = queryAll();
        for (ZhangWu z:zhangWuList) {
            ++xuhao1;
            if (xuhao1 == xuhao){
                zhangwuId = z.getId();
                break;
            }
        }

        //1.编写sql
        String sql = "DELETE FROM bills \n" +
                "WHERE id = ?";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {zhangwuId};
        //4.处理执行
        boolean f = false;
        try {
            do {
                System.out.println("是否删除Y/N");
                Scanner sc = new Scanner(System.in);
                String result = sc.next();
                if (result.equals("Y")) {
                    int n = queryRunner.update(sql, params);
                    if (n > 0) {
                        System.out.println("删除成功");
                        f = false;
                    } else {
                        System.out.println("删除失败");
                    }
                } else if (result.equals("N")) {
                    System.out.println("取消删除成功！");
                    f = false;
                } else if (result.equals("0")){
                    System.out.println("退出删除操作");
                    f = false;
                } else {
                    System.out.println("输入有误请重新输入");
                    f = true;
                }
            } while (f);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateZhangWu(Integer xuhao) {
        int xuhao1 = 0;
        int zhangwuId = 0;
        List<ZhangWu> zhangWuList = queryAll();
        for (ZhangWu z:zhangWuList) {
            ++xuhao1;
            if (xuhao1 == xuhao){
                zhangwuId = z.getId();
                break;
            }
        }

        //1.编写sql
        String sql = "SELECT bs.title,bs.USER,bs.bill_time,bs.type_id,bs.price,bs.EXPLAIN\n" +
                "FROM bills bs\n" +
                "WHERE bs.id = ? " ;
                //"AND bs.type_id = bt.id"

        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {zhangwuId};

        //4.处理执行

        try {
            ZhangWu zhangWu = queryRunner.query(sql,new BeanHandler<>(ZhangWu.class),params);
            //标题
            String titlegai = null;
            System.out.println("标题："+zhangWu.getTitle());
            System.out.println("修改：");
            Scanner scanner = new Scanner(System.in);
            String ti = scanner.nextLine();
            String xiugaiti = "";
            boolean flag = false;
            do {
                xiugaiti = ti;
                if (xiugaiti != null&&xiugaiti.length()!=0){
                    titlegai = xiugaiti;
                }else if (xiugaiti.length()==0){
                    titlegai = zhangWu.getTitle();
                }
            }while (flag);

            //用户
            String usergai = null;
            System.out.println("用户：" + zhangWu.getUser());
            System.out.println("修改：");
            String us = scanner.nextLine();
            String xiugaius = "";
            do {
                xiugaius = us;
                if (xiugaius !=null&&xiugaius.length()!=0){
                    usergai = xiugaius;
                }else if (xiugaius.length()==0){
                    usergai = zhangWu.getUser();
                }
            }while (flag);

            //日期
            String datagai = null;
            System.out.println("日期：" + zhangWu.getBill_time());
            System.out.println("修改：");
            String da = scanner.nextLine();
            String xiugaida = "";
            do {
                xiugaida = da;
                if (xiugaida != null&&xiugaida.length()!=0){
                    datagai = xiugaida;
                }else if (xiugaida.length()==0){
                    datagai = zhangWu.getBill_time();
                }
            }while (flag);

            //账目类型
            String typegai = null;
            System.out.println("账目类型：" + zhangWu.getType_id());
            System.out.println("请选择：1.支出  2.收入  3.借出  4.还入  5.借入  6.还出  7.不限");
            String ty = scanner.nextLine();
            String xiugaity = "";
            do {
                xiugaity = ty;
                if (xiugaity != null&&xiugaity.length()!=0){
                    typegai =  xiugaity;       //类型本来是int   可能出现问题、、、、、、、、、、、、
                }else if (xiugaity.length()==0){
                    typegai = String.valueOf(zhangWu.getType_id());
                }
            }while (flag);

            //账目金额
            String pricegai = null;         ///int类型、、、、、、、、、、、、、、、、、
            System.out.println("账目金额：" + zhangWu.getPrice());
            System.out.println("修改：");
            String pr = scanner.nextLine();
            String xiugaipr = "";
            do {
                xiugaipr = pr;
                if (xiugaipr != null&&xiugaipr.length()!=0){
                    pricegai = xiugaipr;
                }else if (xiugaipr.length()==0){
                    pricegai = String.valueOf(zhangWu.getPrice());
                }
            }while (flag);

            //说明
            String explaingai = null;
            System.out.println("说明：" + zhangWu.getExplain());
            System.out.println("修改：");
            String ex = scanner.nextLine();
            String xiugaiex = "";
            do {
                xiugaiex = ex;
                if (xiugaiex != null&&xiugaiex.length()!=0){    //不为空，同时不为回车
                    explaingai = xiugaiex;
                }else if (xiugaiex.length()==0){    //为回车
                    explaingai = zhangWu.getExplain();
                }
            }while (flag);


        //修改数据
            //1.编写sql
            String sql2 = "UPDATE bills bs SET bs.title = ?,bs.USER = ?,bs.bill_time = ?,\n" +
                    "bs.type_id=?,\n" +
                    "bs.price=?,bs.EXPLAIN=?\n" +
                    "WHERE bs.id=?\n";
            //2.打印sql
            System.out.println(sql2);
            //3.传递参数
            Object[] params2 = {titlegai,usergai,datagai,Integer.valueOf(typegai).intValue(),Integer.valueOf(pricegai).intValue(),explaingai,zhangwuId};
            //4.执行
            int update = queryRunner.update(sql2, params2);
            if(update>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ZhangWu> sortBytitle(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN\n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.type_id = bt.id\n" +
                "ORDER BY CONVERT (bs.title USING gbk) ASC limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {index};
        //4.执行处理
        try {
            List<ZhangWu> res = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (res != null && res.size() > 0){
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> sortBydata(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN\n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.type_id = bt.id\n" +
                "ORDER BY bs.bill_time limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {index};
        //4.执行处理
        try {
            List<ZhangWu> res = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (res != null && res.size() > 0){
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> sortByuser(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN\n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.type_id = bt.id\n" +
                "ORDER BY CONVERT (bs.user USING gbk) ASC limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {index};
        //4.执行处理
        try {
            List<ZhangWu> res = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (res != null && res.size() > 0){
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ZhangWu> sortByprice(ZhangWu zhangWu,Integer index) {
        //1.编写sql
        String sql = "SELECT bs.title,bs.USER,bs.bill_time,bt.NAME,bs.price,bs.EXPLAIN\n" +
                "FROM bills bs,bill_type bt\n" +
                "WHERE bs.type_id = bt.id\n" +
                "ORDER BY bs.price limit ?,5";
        //2.打印sql
        System.out.println(sql);
        //3.传入参数
        Object[] params = {index};
        //4.执行处理
        try {
            List<ZhangWu> res = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class),params);
            if (res != null && res.size() > 0){
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCPoolUtils.getDataSource().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}