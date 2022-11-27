/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
        public static void menu_main(){
            System.out.println();
            System.out.println("||=================== Menu =================||");
            System.out.println("||1. Tao 1 danh sach moi                    ||");
            System.out.println("||2. Xuat danh sach                         ||");
            System.out.println("||3. Them 1 doi tuong vao danh sach         ||");
            System.out.println("||4. Them N doi tuong vao danh sach         ||");
            System.out.println("||5. Xoa 1 doi tuong khoi danh sach         ||");
            System.out.println("||6. Tim kiem trong danh sach               ||");
            System.out.println("||7. Mua hang                               ||");
            System.out.println("||8. Thong ke                               ||");
            System.out.println("||9. Xuat thong tin duoi dang file text     ||");
            System.out.println("||10.Thoat                                  ||");
            System.out.println("||==========================================||");
            System.out.println();
        }
        public static void menu_tao(){
            System.out.println();
            System.out.println("||================ Menu Tao DS =============||");
            System.out.println("||1. Nhap danh sach tu ban phim             ||");
            System.out.println("||2. Lay danh sach tu file                  ||");
            System.out.println("||3. Thoat phan tao DS                      ||");
            System.out.println();
        }
        
        public static void menu_tao1(){
            System.out.println();
            System.out.println("==== Nhap danh sach tu ban phim =====");
            System.out.println("1. Nhap kho cac san pham");
            System.out.println("2. Nhap danh sach cac nhan cong");
            System.out.println("3. Thoat");
            System.out.println();

        }
        public static void menu_tao2(){
            System.out.println();
            System.out.println("==== Lay danh sach tu file =====");
            System.out.println("1. Nhap kho cac san pham");
            System.out.println("2. Nhap danh sach cac nhan cong");
            System.out.println("3. Thoat");
            System.out.println();
        }
        public static void menu_xuat(){
            System.out.println();
            System.out.println("||================ Menu Xuat DS =============||");
            System.out.println("||1. Xuat kho san pham                       ||");
            System.out.println("||2. Xuat danh sach nhan cong                ||");
            System.out.println("||3. Thoat phan xuat DS                      ||");
            System.out.println();
        }
        
        public static void menu_xuatKho(){
            System.out.println();
            System.out.println("1. Xuat danh sach toan Kho");
            System.out.println("2. Xuat danh sach My Pham-MP");
            System.out.println("3. Xuat danh sach Trang Phuc-TT");
            System.out.println("4. Xuat danh sach Van Phong Pham-PP");
            System.out.println("5. Xuat danh sach Thuc Pham-TP");
            System.out.println("6. Xuat danh sach Thuc Uong-TU");
            System.out.println("7. Thoat");
            System.out.println();
        }
        
        public static void menu_xuatNC(){
            System.out.println();
            System.out.println("1. Xuat danh sach toan bo Nhan Cong");
            System.out.println("2. Xuat danh sach Quan Ly");
            System.out.println("3. Xuat danh sach Nhan Vien");
            System.out.println("4. Thoat");
            System.out.println();
        }
        
        public static void menu_them1(){
            System.out.println();
            System.out.println("||=========== Menu Them 1 vao DS ===========||");
            System.out.println("||1. Them 1 nhan cong                       ||");
            System.out.println("||2. Them 1 san pham                        ||");
            System.out.println("||3. Thoat phan Them 1 vao DS               ||");
            System.out.println();
        }
        public static void menu_themN(){
            System.out.println();
            System.out.println("||=========== Menu Them N vao DS ===========||");
            System.out.println("||1. Them N nhan cong                       ||");
            System.out.println("||2. Them N san pham                        ||");
            System.out.println("||3. Thoat phan Them 1 vao DS               ||");
            System.out.println();
        }
        public static void menu_xoa(){
            System.out.println();
            System.out.println("||=========== Menu Xoa khoi DS ============||");
            System.out.println("||1. Xoa 1 nhan cong                       ||");
            System.out.println("||2. Xoa 1 san pham                        ||");
            System.out.println("||3. Thoat phan Xoa khoi DS                ||");
            System.out.println();
        }
        public static void menu_tim(){
            System.out.println();
            System.out.println("||============ Menu Tim trong DS ===========||");
            System.out.println("||1. Tim theo nhieu khoa                    ||");
            System.out.println("||2. Tim theo ma                            ||");
            System.out.println("||3. Thoat phan Tim trong DS                ||");
            System.out.println();
        }
        
        public static void menu_tim2(){
            System.out.println();
            System.out.println("==== Tim theo ma =====");
            System.out.println("1. Voi nhan cong");
            System.out.println("2. Voi san pham");
            System.out.println("3. Thoat");
            System.out.println();
        }

        public static void TK(){
            System.out.println();
            System.out.println("||======== Menu Thong ke thong tin =========||");
            System.out.println("||1. Nhan vien                              ||");
            System.out.println("||2. Doanh thu cua hang                     ||");
            System.out.println("||3. Thoat thong ke thong tin               ||");
            System.out.println();
        }

        public static void fileTxt(){
            System.out.println();
            System.out.println("||========== Menu xuat file text ===========||");
            System.out.println("||1. San pham                               ||");
            System.out.println("||2. Nhan cong                              ||");
            System.out.println("||3. Hoa don                                ||");
            System.out.println("||4. Thoat menu thong ke                    ||");
            System.out.println();
        }
        public static void main(String[] args) throws IOException {
        Kho objSP = new Kho();
        ListNhanCong objNC = new ListNhanCong();
        GioHangList objGH=new GioHangList();
        objGH.setDefault();
        int x=0;
        while (x!=10){ 
            menu_main();
            Scanner sc=new Scanner(System.in);
            System.out.print("Nhap lua chon: ");
            x = Integer.parseInt(sc.nextLine());
            switch(x){
                //1.TAO DS
                case 1 -> { int x1=0;
                            while (x1!=3){
                                menu_tao();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> { 
                                        int x11=0;
                                        while (x11 != 3) {
                                            menu_tao1();
                                            System.out.print("Nhap lua chon: ");
                                            x11 = Integer.parseInt(sc.nextLine());
                                            switch (x11) {
                                                case 1 ->
                                                {
                                                    objSP.input_List();
                                                    break;
                                                }
                                                case 2 ->
                                                {
                                                    objNC.input_List();
                                                    break;
                                                }
                                                case 3 -> {
                                                    break;
                                                }

                                            }
                                        }
                                        break;
                                    }
                                    case 2 -> {
                                        int x12 = 0;
                                        while (x12 != 3) {
                                            menu_tao2();
                                            System.out.print("Nhap lua chon: ");
                                            x12 = Integer.parseInt(sc.nextLine());
                                            switch (x12) {
                                                case 1 -> {
                                                    objSP.readFILE();
                                                    System.out.println("Them thanh cong");
                                                    break;
                                                }
                                                case 2 ->
                                                {
                                                    objNC.readFILE();
                                                    System.out.println("Them thanh cong");
                                                    break;
                                                }
                                                case 3 -> {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3 -> {break;}
                                }
                            }
                            break;
                }
                //2. XUAT
                case 2 -> {
                            int x2=0;
                            while (x2!=3){
                                menu_xuat();
                                System.out.print("Nhap lua chon: ");
                                x2 = Integer.parseInt(sc.nextLine());
                                switch(x2){
                                    case 1 -> { 
                                        int x21=0;
                                        while (x21 != 7) {
                                            menu_xuatKho();
                                            System.out.print("Nhap lua chon: ");
                                            x21 = Integer.parseInt(sc.nextLine());
                                            switch (x21) {
                                                case 1 ->
                                                {
                                                    objSP.output_List();
                                                    break;
                                                }
                                                case 2 ->
                                                {
                                                    objSP.output_ListMP();
                                                    break;
                                                }
                                                case 3 -> 
                                                {
                                                    objSP.output_ListTT();
                                                    break;
                                                }
                                                case 4 -> 
                                                {
                                                    objSP.output_ListPP();
                                                    break;
                                                }
                                                case 5 -> 
                                                {
                                                    objSP.output_ListTP();
                                                    break;
                                                }
                                                case 6 -> 
                                                {
                                                    objSP.output_ListTU();
                                                    break;
                                                }
                                                case 7 -> {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2 -> {
                                        int x22 = 0;
                                        while (x22 != 4) {
                                            menu_xuatNC();
                                            System.out.print("Nhap lua chon: ");
                                            x22 = Integer.parseInt(sc.nextLine());
                                            switch (x22) {
                                                case 1 -> 
                                                {
                                                    objNC.output_List();
                                                    break;
                                                }
                                                case 2 ->
                                                {
                                                    objNC.output_ListQL();
                                                    break;
                                                }
                                                case 3 -> 
                                                {
                                                    objNC.output_ListNV();
                                                    break;
                                                }
                                                case 4 ->{
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3 -> {break;}
                                    }
                            }
                            break;
                        }
                //3.THEM 1
                case 3 -> {
                            int x1=0;
                            while (x1!=3){
                                menu_them1();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> 
                                    {
                                        objNC.List = objNC.AddList1();
                                        break;
                                    }
                                    case 2 -> 
                                    {
                                        objSP.List = objSP.AddList1();
                                        break;
                                    }
                                    case 3 -> {
                                        break;
                                    }
                                }
                            }
                            break;
                }
                //4.THEM N
                case 4 -> {
                            int x1=0;
                            while (x1!=3){
                                menu_themN();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> 
                                    {
                                        objNC.List = objNC.AddListn();
                                        break;
                                    }
                                    case 2 -> 
                                    {
                                        objSP.List = objSP.AddListn();
                                        break;
                                    }
                                    case 3 -> {
                                        break;
                                    }
                                }
                            }
                            break;
                }
                //5.XOA
                case 5 -> {
                            int x1=0;
                            while (x1!=3){
                                menu_xoa();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> 
                                    {
                                        objNC.List = objNC.Delete();
                                        break;
                                    }
                                    case 2 -> 
                                    {
                                        objSP.List = objSP.Delete();
                                        break;
                                    }
                                    case 3 -> {
                                        break;
                                    }
                                }
                            }
                            break;
                }
                //6.TIM
                case 6 ->   {
                            int x1=0;
                            while (x1!=3){
                                menu_tim();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> { 
                                        objSP.searchTL();
                                        break;
                                    }
                                    case 2 -> {
                                        int x12 = 0;
                                        while (x12 != 3) {
                                            menu_tim2();
                                            System.out.print("Nhap lua chon: ");
                                            x12 = Integer.parseInt(sc.nextLine());
                                            switch (x12) {
                                                case 1 -> 
                                                {
                                                    objNC.search();
                                                    break;
                                                }
                                                case 2 ->
                                                {
                                                    objSP.searchH_G();
                                                    break;
                                                }
                                                case 3 -> {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3 -> {break;}
                                }
                            }
                            break;
                }
                //7. MUA HANG
                case 7 -> {
                    objSP.output_List();
                    System.out.println("Hay nhap so luong san pham muon mua : ");
                    int n=Integer.parseInt(sc.nextLine());
                    String KHMa="";
                    String KHTen="";
                    int KHSl=0;
                    long KHGia=0;
                    int i,j,check=-1,check1=-1;
                    GioHang KH=new GioHang();
                    KH.Cus.input();
                    KH.n=n;
                    Don KHDon[]=new Don[n];
                    for(i=0;i<n;i++)
                    {
                        while(true){
                            System.out.printf("Hay nhap ma so san pham thu %d: ",i+1);
                            KHMa=sc.nextLine();
                            for(j=0;j<objSP.List.length;j++)
                            {
                                if(objSP.List[j].MaSP.equals(KHMa))
                                {
                                    while(true)
                                    {
                                        System.out.print("Hay nhap so luong muon mua :");
                                        KHSl=Integer.parseInt(sc.nextLine());
                                        if(KHSl<objSP.List[j].Sl && KHSl >0)
                                        {
                                            KHTen=objSP.List[j].Ten;
                                            KHGia=objSP.List[j].Gia;
                                            objSP.List[j].Sl=objSP.List[j].Sl-KHSl;
                                            check1=0;
                                        }
                                        else if(KHSl==objSP.List[j].Sl)
                                        {
                                            KHTen=objSP.List[j].Ten;
                                            KHGia=objSP.List[j].Gia;
                                            objSP.List=objSP.DeleteWithout(j);
                                            check1=0;
                                        }
                                        if(check1==0) {check1=-1;break;}
                                        else {System.out.println("So luong ban muon mua khong phu hop! Vui long nhap lai!");}
                                    }
                                    check=0;
                                }
                            }
                            if(check==0) {check=-1;break;}
                            else
                            {System.out.println("Ma so cua san pham khong ton tai! Vui long nhap lai!");}
                        }
                        KHDon[i]=new Don(KHMa,KHTen,KHSl,KHGia);
                    }
                    KH.List=KHDon;
                    KH.Emp=objNC.randomTN();
                    KH.HoaDon();
                    objGH.List=objGH.input(KH);
                    break;
                }
                //THONG KE
                case 8 -> {
                    int x1=0;
                            while (x1!=3){
                                TK();
                                System.out.print("Nhap lua chon: ");
                                x1 = Integer.parseInt(sc.nextLine());
                                switch(x1){
                                    case 1 -> { 
                                        objNC.ThongKe();
                                        break;
                                    }
                                    case 2 -> { 
                                        objGH.ThongKeDH();
                                        break;
                                    }
                                    case 3 -> { 
                                        break;
                                    }
                                }    
                            }        
                    break;
                }
                case 9 -> {
                    int x1=0;
                    while (x1!=4){
                        fileTxt();
                        System.out.print("Nhap lua chon: ");
                        x1 = Integer.parseInt(sc.nextLine());
                        switch(x1){
                            case 1 -> { 
                                objSP.writeFILE();
                                System.out.print("In thanh cong!");
                                break;
                            }
                            case 2 -> { 
                                objNC.writeFILE();
                                System.out.print("In thanh cong!");
                                break;
                            }
                            case 3 -> { 
                                objGH.ThongKeKH();
                                objGH.Chose();
                                System.out.print("In thanh cong!");
                                break;
                            }
                            case 4 -> { 
                                break;
                            }
                        }    
                    }        
                    break;
                }
                case 10 -> {break;}
            }
        }
}     
}