package com.tocgic.exam.study_java_basic.week13;

import javax.annotation.Nonnull;
import java.io.*;

public class FileExam {
    public File getFile(@Nonnull String directory, @Nonnull String fileName) {
        File source = new File(directory, fileName);
        if (!source.exists()) {
            try {
                File parent = source.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                source.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.err.println("source : " + source.getAbsolutePath());
            }
        }
        return source;
    }

    public void writeRead(@Nonnull File source, String... args) {
        try (FileWriter writer = new FileWriter(source)) {
            for (String arg : args) {
                writer.write(arg + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader(source)) {
            char ch;
            while ((ch = (char)reader.read()) > Character.MIN_VALUE && ch < Character.MAX_VALUE) {
                System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeReadWithBuffer(@Nonnull File source, String... args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
            for (String arg : args) {
                writer.write(arg + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileExam fileExam = new FileExam();

        final String directory = "test";
        final String fileName = "test.txt";

        File source = fileExam.getFile(directory, fileName);
        fileExam.writeRead(source, "FileWriter 를 사용하여 파일 쓰기", "FileReader 를 사용하여 파일 읽기");
        fileExam.writeReadWithBuffer(source, "BufferedWriter 를 사용하여 파일 쓰기", "BufferedReader 를 사용하여 파일 읽기");
    }
}
