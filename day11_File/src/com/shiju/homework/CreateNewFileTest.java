package com.shiju.homework;

import java.io.File;
import java.io.IOException;

/**
 * 请编写main()方法，创建以下File对象：
 * 		File file1 = new File(“test.txt”);//相对路径，在项目根目录下
 * 		File file2 = new File(“一级目录”);
 * 		File file3 = new File(“目录A/目录B/目录C”);
 * 	要求：
 * 		1. 判断file1是否存在？如果不存在，创建这个文件。
 * 		2. 判断file2是否存在？如果不存在，创建这个目录。
 * 		3. 判断file3是否存在？如果不存在，创建这个多级目录。
 * @author shiju
 * @date 2021/04/02 21:13
 **/
public class CreateNewFileTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test.txt");
        File file2 = new File("一级目录");
        File file3 = new File("目录A/目录B/目录C");
        //判断file1是否存在？如果不存在，创建这个文件
        if(!file1.exists()){
            file1.createNewFile();
        }
        //判断file2是否存在？如果不存在，创建这个目录
        if (!file2.exists()){
            file2.mkdirs();
        }
        //判断file3是否存在？如果不存在，创建这个多级目录
        if(!file3.exists()){
            file3.mkdirs();
        }
    }
}
