package dev.idion.jasyptencryptor;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Scanner;

public class Encryptors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String envVar = null;
        while (envVar == null) {
            System.out.println("환경변수 명을 입력해주세요. / Please Write Environment Variable Key, Name");
            envVar = System.getenv(sc.nextLine());
        }

        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(envVar); //2번 설정의 암호화 키를 입력

        while (true) {
            System.out.println("암호화 할 값을 입력해주세요. 종료하시려면 x를 입력해주세요.");
            // 암호화 할 값
            String value = sc.nextLine();
            if ("x".equals(value)) {
                break;
            }
            System.out.println("암호화 된 값: " + pbeEnc.encrypt(value));
        }
    }
}
