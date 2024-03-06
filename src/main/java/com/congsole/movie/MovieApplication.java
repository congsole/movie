package com.congsole.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);

//		for(int i = 2; i<10; i++) {
//			if(i%2==0) {
//				for(int j =1; j<6; j++) {
//					System.out.println(i + "*" + j + " =" + i*j);
//				}
//			}
//			else {
//				for(int j=5; j<10; j++) {
//					System.out.println(i + "*" + j + " =" + i*j);
//				}
//
//			}
//		}

		int k =1;
		int w =6;
		for(int i = 0; i<9; i++) {
			for(int j = 2; j<10; j++) {
				if(j%2 == 0 && k<=5) {
					System.out.print(j + "*" + k + "=" + j*k + "\t");
				} else if (j%2==1 && w<10) {
					System.out.print(j + "*" + w + "=" + j*w + "\t");
				} else if (j%2==1 && w==10) {
					System.out.print("\t\t");
				}
			}
					k += 1;
					w += 1;
				System.out.println();
		}
	}

}
