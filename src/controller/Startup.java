package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.ModelDanhGia;
import model.ModelUser;
import model.modelProduct;
import RecomanderSystems.Matran;
import bean.AverageProduct;
import bean.DanhGia;
import bean.Product;
import bean.User;

public class Startup implements ServletContextListener, Runnable {

    /**
     * Default constructor. 
     */
    public Startup() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        
    }

    public void contextInitialized(ServletContextEvent arg0) {
        new Thread(this).start();
    }

	@Override
	public void run() {
		ModelUser mUser = new ModelUser();
		modelProduct mPro = new modelProduct();
		ModelDanhGia mDanhGia = new ModelDanhGia();
		ArrayList<User> alUser = mUser.getList();
		ArrayList<Product> alProducts = mPro.getList();
		ArrayList<DanhGia> alDanhGias = mDanhGia.getList();
		int m = alUser.size();
		int n = alProducts.size();
		//ma trận dtrain gồm m hàng users và n cột products
		System.out.println("MA TRAN DTRAIN");
		float dTrain[][] = new float[m][n];
		Random rd = new Random();
		for(int i=0;i<m;i++){
			for (int j = 0; j < n; j++) {
				dTrain[i][j] = rd.nextInt(5)+1;
				System.out.print(dTrain[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		System.out.println("==================================");
		//ma trận dtest gồm m hàng users và n cột products
		System.out.println("MA TRAN DTEST");
		float dTest[][] = new float[m][n];
		for(int i=0;i<m;i++){
			for (int j = 0; j < n; j++) {
				for (DanhGia objDanhGia :alDanhGias ) {
					if(objDanhGia.getIdUsers() == alUser.get(i).getId() && objDanhGia.getIdProducts() == alProducts.get(j).getId()){
						dTest[i][j] = objDanhGia.getDanhgia();
						break;
					}
				}
				System.out.print(dTest[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		//phân rã ma trận d test thành w và h có chỉ số k = 2
		Matran mt = new Matran(m, n);
		System.out.println("==================================");
		System.out.println("MA TRAN W");
		float w[][] = mt.randomMatran(alUser.size(), 2);
		System.out.println("MA TRAN H");
		float h[][] = mt.randomMatran(2, alProducts.size());
		//tim chuẩn:
		float oMF = mt.timchuan(w, h, dTrain);
		System.out.println("CHUAN BAN DAU: "+oMF);
		System.out.println("===================================");
		ArrayList<AverageProduct>alAverage = mt.phanRaMT(w, h, dTrain, dTest);
		int index = 0;
		for (AverageProduct averageProduct : alAverage) {
			int idProduct = alProducts.get(index).getId();
			averageProduct.setProductId(idProduct);
			index++;
			System.out.println(averageProduct.toString());
		}
		mDanhGia.deleteItem();
		for (AverageProduct averageProduct : alAverage) {
			mDanhGia.addAverage(averageProduct);
		}
	}
	
}
