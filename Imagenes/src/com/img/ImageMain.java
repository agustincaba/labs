package com.img;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageMain {

	public static void main(String[] args) throws Exception {
        char[] c={'#','X','%','*','+',':','.',' '};
        //char[] c={'X','N','S','T','I','x','.',' '};
		int nx=120;
	    int ny=80;
	    BufferedImage bi=ImageIO.read(new File("C:\\opt\\imagenes\\P1060974.JPG"));
	    int bx=bi.getWidth()/nx;
	    int by=bi.getHeight()/ny;
	    //int by= bx* ( bi.getWidth()/ bi.getWidth());
	    int[][] img=new int[ny][nx];
	    System.out.println("Ancho=" + bx +  " Alto=" + by);
		for(int x=0;x<nx;x++){
			for(int y=0;y<ny;y++){
					img[y][x]=promedio(bi,x,y,bx,by);
				
			}
		}
		for(int y=0;y<ny;y++){
			for(int x=0;x<nx;x++){
					System.out.print(c[img[y][x]/100]);
			}
			System.out.println();
		}
	}

	private static int promedio(BufferedImage bi, int x, int y, int bx, int by) {
		int suma=0;
		int valor=0;
		for(int i=0;i<by;i++){
			for(int j=0;j<bx;j++){
				Color c = new Color(bi.getRGB(x*bx+j, y*by+i));
				valor= c.getBlue()+c.getGreen()+c.getRed();
				suma+=valor;
			}
		}
		return suma/ (bx*by);
	}

}
