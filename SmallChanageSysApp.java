import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallChanageSysApp {
    public static void main(String[] args) {        
        //定义相关的变量
        Scanner scanner = new Scanner(System.in);
        String choose = "";
        boolean loop = true;
    // 可以把收益入账和消费，保存到数组 或可以使用对象 或使用String拼接
    //这里用String 拼接
        String details = "===========零钱通明细===========";
    // 完成收益入账 完成功能驱动程序员增加新的变化和代码
    // 定义新的变量balance 和 money
        double money = 0;
        double balance = 0;
        Date date = null;//deat 是java.util.Date 类型，表示日期 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化
    //增加消费方法 定义新的变量，保存消费的原因
        String note = "";
    // 先完成显示菜单，并可以选择,给出相应提示
    // 完成零钱通明细
        do{
            System.out.println("\n===========零钱通菜单===========\n");
            System.out.println(" \t(1) 零钱通明细");
            System.out.println(" \t(2) 收益入账");
            System.out.println(" \t(3) 消费情况");
            System.out.println(" \t(4) 退出");

            System.out.print("\n请选择(1-4): ");
            choose = scanner.next();
            switch(choose){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("请输入本次收益入账金额: ");
                    money = scanner.nextDouble();
                    //money的值应该校验一下，一会完善
                    balance += money;
                    //拼接收益入账信息 details
                    date = new Date();//获取当前日期
                    //拼接字符串输出明细列表
                    details += "\n\n收益入账\t+" + money + "\t" + sdf.format(date) + " 总收入:" + balance;  
                    break;
                case "3":
                    System.out.print("消费金额: ");
                    money = scanner.nextDouble();
                    //money值的范围应该校验
                    System.out.print("请输入消费说明: ");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息到details
                    date = new Date();//获取当前日期
                    //拼接字符串输出明细列表
                    details += "\n\n" + note + "\t\t-" + money + "\t" + sdf.format(date) + " 余额:" + balance;  
                    break;
                case "4":
                    System.out.println("4 退出");
                    //添加询问是否退出系统
                    //建议一段代码完成一段小功能，不要混合在一起
                    String choice;//用户输入y或n
                    bookmark: //书签,用于查看代码便利
                    while(true){
                    System.out.print("您确定要退出系统吗?(y/n): ");
                    choice = scanner.next();
                    if(choice.equals("y") || choice.equals("n")){//必须输入y或n,否则一直循环
                        break bookmark;
                    }
                }
                //当用户退出While后，进行判断
                    if(choice.equals("y")){
                        loop = false;//退出系统，将循环的条件改为false
                            System.out.println("===========退出了零钱通项目===========");
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }
        }while(loop);
    }
}