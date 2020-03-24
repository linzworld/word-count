package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Description 文件操作方法的封装
 * @Author 林泽鸿
 * @Date 2020/3/24 19:21
 */
public class FileUtil {

    //获取处理文件对象
    public static BufferedReader fileWrapper(String fileName) throws FileNotFoundException {
        //定义一个file对象，用来初始化FileReader
        File file = new File(fileName);
        //定义一个fileReader对象，用来初始化BufferedReader
        FileReader fileReader = new FileReader(file);
        //new一个BufferedReader对象，将文件内容读取到缓存
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}
