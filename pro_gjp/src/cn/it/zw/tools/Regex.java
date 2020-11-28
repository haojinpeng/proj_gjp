package cn.it.zw.tools;

public class Regex {
    public static String menuRegex (int min, int max ){  // 对菜单输入选项的验证
        return "["+min+"-"+max+"]"+"{1}";
    }
    public static String userRegex ( ){  // 对用户输入姓名的验证
        return "[\\u4e00-\\u9fa5]{1,4}";
    }
    public static String titleRegex ( ){  // 对用户输入标题的验证
        return "[\\u4e00-\\u9fa5]{1,30}";
    }
    public static String infoRegex ( ){  // 对用户输入的验证
        return "[\\u4e00-\\u9fa5]{2,20}";
    }
    public static String dateRegex ( ){  // 对用户输入日期的验证
        return "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    }
    public static String decimalsRegex(){
        return "[0-9]{1,4}[.][0-9]{1,2}";
    }

    //价格正则，小数点后只能有两位
    public boolean priceRegex(String price){
        String regex=("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        //Integer integer = new Integer(id);
        return price.matches(regex);
    }

    public static String priceRegex(){
        return "^([1-9][0-9]*)$";
    }

    public static String explainRegex(){
        return "[\\u4e00-\\u9fa5]{1,80}";
    }
}
