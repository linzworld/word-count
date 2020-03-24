package controller;

import service.BasicService;

import java.io.*;
import java.util.Scanner;

/**
 * @Description 控制台显示
 * @Author 林泽鸿
 * @Date 2020/3/21 10:48
 */
public class ConsoleController {
    //获得输入的命令参数和目录或者文件名
    public static  String[]  getInput(){
        System.out.println("please input '[order] [filename]':");
        System.out.print("wc.exe ");
        Scanner input=new Scanner(System.in);
        //接受String类型,通过一个或者多个空格进行分割
         String commandList[]=input.nextLine().split("\\s+");
         return commandList;
    }

    //选择命令，并执行
   public static void selectCommand(String command,String fileName) throws IOException
    {
        System.out.println("当前文件名为："+fileName);
        // 实例化workCount
        switch (command) {//判断命令并执行
            case "-c":
                BasicService.charCount(fileName);
                System.out.println("字符数："+BasicService.character);
                break;
            case "-l":
                BasicService.lineCount(fileName);
                System.out.println("行数："+BasicService.line);
                break;
            case "-w":
                BasicService.wordCount(fileName);
                System.out.println("单词数："+BasicService.word);
                break;
            case "-a":
                BasicService.codeLineCount(fileName);
                BasicService.nullLineCount(fileName);
                BasicService.commentLineCount(fileName);
                System.out.println("代码行数："+BasicService.codeLine);
                System.out.println("空行数："+BasicService.nullLine);
                System.out.println("注释行数："+BasicService.commentLine);
                break;
            case "-s":
                //BasicService.getAllFilefileName(fileName);
                break;
            default:
                System.out.println("当前命令格式不存在！ "+command);
                break;
        }
    }
}
