package minimarket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Kho implements subMenu{
    private int n;
    Sanpham List[];
    Scanner sc=new Scanner(System.in);
    private static String readF="SP_R.txt";
    private static String writeF="SP_W.txt";

    public int Getn(){
        return n;
    }

    public void Setn(int n){
        this.n=n;
    }

    public Sanpham[] getList(){
        return List;
    }

    public void setList(Sanpham[] List){
        this.List=List;
    }

    public void input_List(){
        System.out.println("Hay nhap so luong san pham :");
        n=Integer.parseInt(sc.nextLine());
        List=new Sanpham[n];
        int choice;
        boolean flag=true;
        for(int i=0;i<n;i++){
            System.out.printf("Hay nhap san pham thu %d : \n",i+1);
            System.out.println("1.My pham\n"+"2.Thoi trang\n"+"3.Van phong pham\n"+"4.Thuc pham\n"+"5.Thuc uong\n");
            System.out.print("Hay chon loai san pham muon them :");
            choice=Integer.parseInt(sc.nextLine());
            do
            {
            switch (choice) {
                case 1:
                {
                    List[i]=new MyPham();
                    List[i].Input();
                    flag=false;
                    break;
                }
                case 2:
                {
                    List[i]=new ThoiTrang();
                    List[i].Input();
                    flag=false;
                    break;
                }
                case 3:
                {
                    List[i]=new VPPham();
                    List[i].Input();
                    flag=false;
                    break;
                }
                case 4:
                {
                    List[i]=new ThucPham();
                    List[i].Input();
                    flag=false;
                    break;
                }
                case 5:
                {
                    List[i]=new ThucUong();
                    List[i].Input();
                    flag=false;
                    break;
                }
                default:
                {
                    System.out.println("Lua chon khong phu hop vui long nhap lai ");
                    break;
                }
            }
            }while(flag);
        }
    }

    public void readFILE(){
        try{
            FileReader fr =new FileReader(readF);
            BufferedReader br=new BufferedReader(fr);
            String line="";
            line=br.readLine();
            String temp[]=line.split(" ");
            int count=Integer.parseInt(temp[1]);
            n=count;
            int d,m,y,i=0;
            List=new Sanpham[n];
            while(true){
                line=br.readLine();
                if(line==null){
                    break;
                }
                String txt[]=line.split(",");
                String ID=txt[0];
                String Name=txt[1];
                String DTNSX=txt[2];
                d=Integer.parseInt(DTNSX.substring(0,2));
                m=Integer.parseInt(DTNSX.substring(2,4));
                y=Integer.parseInt(DTNSX.substring(4));
                Date nsx= new Date(d,m,y);
                String DTHSD=txt[3];
                d=Integer.parseInt(DTHSD.substring(0,2));
                m=Integer.parseInt(DTHSD.substring(2,4));
                y=Integer.parseInt(DTHSD.substring(4));
                Date hsd= new Date(d,m,y);
                String Brand=txt[4];
                int Num=Integer.parseInt(txt[5]);
                Long Cost=Long.parseLong(txt[6]);
                if(ID.substring(0,2).equals("MP"))
                {
                    String Loai=txt[7];
                    List[i]=new MyPham(ID,Name,hsd,nsx,Cost,Brand,Num,Loai);
                }
                if(ID.substring(0,2).equals("TT"))
                {
                    String Sex=txt[7];
                    boolean gt;
                    if(Sex.equals("Nam")){
                        gt=true;
                    }
                    else
                    {
                        gt=false;
                    }
                    List[i]=new ThoiTrang(ID,Name,hsd,nsx,Cost,Brand,Num,gt);
                }
                if(ID.substring(0,2).equals("PP"))
                {
                    String CL=txt[7];
                    String DT=txt[8];
                    List[i]=new VPPham(ID,Name,hsd,nsx,Cost,Brand,Num,CL,DT);
                }
                if(ID.substring(0,2).equals("TP"))
                {
                    String CB=txt[7];
                    List[i]=new ThucPham(ID,Name,hsd,nsx,Cost,Brand,Num,CB);
                }
                if(ID.substring(0,2).equals("TU"))
                {
                    String L=txt[7];
                    String DG=txt[8];
                    List[i]=new ThucUong(ID,Name,hsd,nsx,Cost,Brand,Num,L,DG);
                }
                
                i++;
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void rewriteFILE(){
        int i;
        try{
            FileWriter fr=new FileWriter(readF);
            BufferedWriter br=new BufferedWriter(fr);
            br.write("Total: "+List.length);
            for(i=0;i<List.length;i++)
            {
                br.write("\n"+List[i].toStringRE());
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeFILE(){
        try{
            FileWriter fw=new FileWriter(writeF);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("\tDanh sach cac mat hang trong kho : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia"));
            for(int i=0;i<List.length;i++)
            {
                bw.write(List[i].toString());
                bw.newLine();
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach cac mat hang my pham : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Loai"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof MyPham){
                bw.write(List[i].toStringL());
                bw.newLine();
                }
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach cac mat hang trang phuc : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-15s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Gioi tinh"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof ThoiTrang){
                bw.write(List[i].toStringL());
                bw.newLine();
                }
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach cac mat hang van phong pham : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Chat lieu","Doi tuong"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof VPPham){
                bw.write(List[i].toStringL());
                bw.newLine();
                }
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach cac mat hang thuc pham : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Che bien"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof ThucPham){
                bw.write(List[i].toStringL());
                bw.newLine();
                }
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach cac mat hang thuc uong : \n\n");
            bw.write(String.format("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Loai","Dong goi"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof ThucUong){
                bw.write(List[i].toStringL());
                bw.newLine();
                }
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void output_ListMP(){
        System.out.println("Danh sach cac mat hang my pham : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Loai");
        for(int i=0;i<List.length;i++)
        {
            if(List[i].MaSP.substring(0,2).equals("MP"))
            {
                System.out.println(List[i].toStringL());
            }
        }
    }

    public void output_ListTT(){
        System.out.println("Danh sach cac mat hang trang phuc : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-15s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Gioi tinh");
        for(int i=0;i<List.length;i++)
        {
            if(List[i].MaSP.substring(0,2).equals("TT"))
            {
                System.out.println(List[i].toStringL());
            }
        }
    }

    public void output_ListPP(){
        System.out.println("Danh sach cac mat hang van phong pham : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Chat lieu","Doi tuong");
        for(int i=0;i<List.length;i++)
        {
            if(List[i].MaSP.substring(0,2).equals("PP"))
            {
                System.out.println(List[i].toStringL());
            }
        }
    }

    public void output_ListTP(){
        System.out.println("Danh sach cac mat hang thuc pham : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Che bien");
        for(int i=0;i<List.length;i++)
        {
            if(List[i].MaSP.substring(0,2).equals("TP"))
            {
                System.out.println(List[i].toStringL());
            }
        }
    }

    public void output_ListTU(){
        System.out.println("Danh sach cac mat hang thuc uong : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s %-20s %-20s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia","Loai","Dong goi");
        for(int i=0;i<List.length;i++)
        {
            if(List[i].MaSP.substring(0,2).equals("TU"))
            {
                System.out.println( List[i].toStringL());
            }
        }
    }

    public void output_List(){
        System.out.println("Danh sach cac mat hang trong kho : ");
        System.out.printf("%-10s %-50s %-20s %-20s %-20s %-10s %-15s\n","Ma","Ten","NSX","HSD","Hang","SL","Gia");
        for(int i=0;i<List.length;i++)
        {
            System.out.println(List[i].toString());
        }
    }

    public Sanpham[] AddList1(){
        int choice;
        Sanpham a=new Sanpham();
        boolean flag=true;
        System.out.println("1.My pham\n"+"2.Thoi trang\n"+"3.Van phong pham\n"+"4.Thuc pham\n"+"5.Thuc uong\n");
        System.out.print("Hay chon lai san pham muon them :");
        choice=Integer.parseInt(sc.nextLine());
        do
        {
        switch (choice) {
        case 1:
            {
                a=new MyPham();
                a.Input();
                flag=false;
                break;
            }
        case 2:
            {
                a=new ThoiTrang();
                a.Input();
                flag=false;
                break;
            }
        case 3:
            {
                a=new VPPham();
                a.Input();
                flag=false;
                break;
            }
        case 4:
            {
                a=new ThucPham();
                a.Input();
                flag=false;
                break;
            }
        case 5:
            {
                a=new ThucUong();
                a.Input();
                flag=false;
                break;
            }
        default:
            {
                System.out.println("Lua chon khong phu hop vui long nhap lai ");
                break;
            }
            }
        }while(flag);
        Sanpham Copied[]=new Sanpham[List.length+1];
        for(int i=0;i<List.length;i++)
        {
            Copied[i]=List[i];
        }
        Copied[List.length]=a;
        n=n+1;
        System.out.println("Them san pham thanh cong !");
        return Copied;
    }

    public Sanpham[] AddListn(){
        int i,k,choice;
        while(true){
            System.out.println("Nhap so san pham can them :");
            k=Integer.parseInt(sc.nextLine());
            if(k>0) break;
            System.out.println("Nhap khong hop le vui long nhap lai");
        }
        Sanpham Copied[]=new Sanpham[List.length+k];
        for(i=0;i<List.length;i++)
        {
            Copied[i]=List[i];
        }
        int t=List.length;
        for(i=0;i<k;i++)
        {
            System.out.printf("Nhap thong tin cua san pham thu %d can them: \n",i+1);
            Sanpham a=new Sanpham();
            boolean flag=true;
            System.out.println("1.My pham\n"+"2.Thoi trang\n"+"3.Van phong pham\n"+"4.Thuc pham\n"+"5.Thuc uong\n");
            System.out.print("Hay chon lai san pham muon them :");
            choice=Integer.parseInt(sc.nextLine());
            do
            {
            switch (choice) {
            case 1:
                {
                    a=new MyPham();
                    a.Input();
                    flag=false;
                    break;
                }
            case 2:
                {
                    a=new ThoiTrang();
                    a.Input();
                    flag=false;
                    break;
                }
            case 3:
                {
                    a=new VPPham();
                    a.Input();
                    flag=false;
                    break;
                }
            case 4:
                {
                    a=new ThucPham();
                    a.Input();
                    flag=false;
                    break;
                }
            case 5:
                {
                    a=new ThucUong();
                    a.Input();
                    flag=false;
                    break;
                }
            default:
                {
                    System.out.println("Lua chon khong phu hop vui long nhap lai ");
                    break;
                }
                }
            }while(flag);
            Copied[t++]=a;
        }
        n=t;
        System.out.println("Them san pham thanh cong !");
        return Copied;
    }

    public Sanpham[] Delete(){
        int i,temp=-1;
        String k;
        while(true){
            System.out.println("Nhap ma so san pham can xoa :");
            k=sc.nextLine();
            for(i=0;i<List.length;i++)
            {
            if(List[i].MaSP.equals(k)){
                temp=i;
                break;
                }
            }
            if(temp==-1)
            {
                System.out.println("Khong tim thay vui long nhap lai");
            }
            else
            {
                break;
            }
        }
        Sanpham Copied[]=new Sanpham[List.length-1];
        for(i=0;i<temp;i++)
        {
            Copied[i]=List[i];
        }
        for(i=temp+1;i<List.length;i++)
        {
            Copied[i-1]=List[i];
        }
        n=n-1;
        System.out.println("Xoa san pham thanh cong !");
        return Copied;
    }

    public Sanpham[] DeleteWithout(int temp){
        int i;
        Sanpham Copied[]=new Sanpham[List.length-1];
        for(i=0;i<temp;i++)
        {
            Copied[i]=List[i];
        }
        for(i=temp+1;i<List.length;i++)
        {
            Copied[i-1]=List[i];
        }
        n=n-1;
        return Copied;
    }

    public Sanpham[] adjust() {
    	boolean flag=false;
    	boolean kiemTraMaTonTai;
    	byte choice=0;
    	int viTri=0;
    	String maTimKiem = "";
    	do {
    		kiemTraMaTonTai=false;
    		System.out.print("Nhap ma san pham can tim : ");
        	maTimKiem = sc.nextLine();
        	for(int i=0;i<List.length;i++) {
        		if (maTimKiem.equals(List[i].getMaSP())) {
        			viTri = i;
        			flag = true;
        		}
        	}
        	if ((!maTimKiem.substring(0,2).equals("MP") || !maTimKiem.substring(0,2).equals("TT") || !maTimKiem.substring(0,2).equals("PP") || !maTimKiem.substring(0,2).equals("TP") || !maTimKiem.substring(0,2).equals("TU")) && maTimKiem.substring(2).length()!=3 || !flag) 
        	{	
        		System.out.println("Dinh dang ma san pham khong dung hoac ma khong ton tai! Vui long nhap lai!");
        		flag = false;
        	}
        	else kiemTraMaTonTai = true;
    	}while (!kiemTraMaTonTai);
    	if (flag) {
    		choice = 0;
    		System.out.println("\n\n-Thong tin can thay doi :");
    		System.out.println("1. Thong tin chung");
    		System.out.println("2. Thong tin rieng cua san pham");
    		System.out.println("3. Toan bo thong tin");
    		System.out.println("0 hoac Enter. Thoat, khong thay doi nưa");
    		do {
    			System.out.print("Lua chon cua ban : ");
    			choice = Byte.parseByte(sc.nextLine());
    			if (choice < 0 || choice >3) System.out.println("Lua chon khong phu hop! Moi nhap lai");
    		}while (choice < 0 || choice >3);
    		if (choice == 1) {
    			byte luaChon=0;
    			System.out.println("\n1. Thay doi|| Other. Khong thay doi");
    			System.out.print("\nThay doi ten? :"); // Doi ten
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ten san pham : ");
    				List[viTri].setTen(sc.nextLine());
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi NXS? :"); // Doi NXS
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ngay san xuat : ");
    				List[viTri].NSX.inputDATE();
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi HSD? :"); // Doi han su dung
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ngay het han : ");
    				List[viTri].HSD.inputDATE();
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi ten hang? :"); // Doi ten hang
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ten hang : ");
    				List[viTri].setHang(sc.nextLine());
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi gia tien? :"); // Doi gia tien
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap gia tien : ");
    				List[viTri].setGia(Long.parseLong(sc.nextLine()));;
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi so luong? :"); // Doi so luong
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap so luong : ");
    				List[viTri].setSl(Integer.parseInt(sc.nextLine()));;
    				luaChon = 0;
    			}
    		}
    		else if (choice == 2) {
    			byte luaChon=0;
    			System.out.println("\n1. Thay doi || Other. Khong thay doi");
    			
    			if (List[viTri] instanceof MyPham) { // MỸ PHẨM
    				System.out.print("\nThay doi loai? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap loai my pham : ");
        				((MyPham) List[viTri]).setLoai(sc.nextLine());
        			}
    			}
    			else if (List[viTri] instanceof ThoiTrang) { //THỜI TRANG
    				System.out.print("\nThay doi gioi tinh? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				boolean check=true;
        		        do{
        		        System.out.println("Hay nhap gioi tinh ( 1:Nam || 0:Nu )");
        		        if(sc.nextLine().equals("1"))
        		        {
        		            ((ThoiTrang) List[viTri]).setGioiTinh(true);
        		            check=false;
        		        }
        		        else if(sc.nextLine().equals("0"))
        		        {
        		        	((ThoiTrang) List[viTri]).setGioiTinh(false);
        		            check=false;
        		        }
        		        else{
        		            System.out.println("Nhap sai vui long nhap lai! ");
        		        }
        		        }while(check);
        			}
    			}
    			
    			else if (List[viTri] instanceof VPPham) {  // VĂN PHÒNG PHẨM
    				System.out.print("\nThay doi chat lieu? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap chat lieu : ");
        				((VPPham) List[viTri]).setChatLieu(sc.nextLine());
        				luaChon = 0;
        			}
        			
        			System.out.print("\nThay doi doi tuong su dung? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap doi tuong su dung : ");
        				((VPPham) List[viTri]).setDoiTuong(sc.nextLine());
        				luaChon = 0;
        			}
    			}
    			
    			else if (List[viTri] instanceof ThucPham) { // THỰC PHẨM
    				System.out.print("\nThay doi cach che bien? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap cach che bien : ");
        				((ThucPham) List[viTri]).setCheBien(sc.nextLine());
        			}
    			}
    			
    			else if (List[viTri] instanceof ThucUong) { // THỨC UỐNG
    				System.out.print("\nThay doi loai? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap loai thuc uong : ");
        				((ThucUong) List[viTri]).setLoai(sc.nextLine());
        				luaChon = 0;
        			}
        			
        			System.out.print("\nThay doi cach dong goi? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap cach dong goi : ");
        				((ThucUong) List[viTri]).setDongGoi(sc.nextLine());;
        			}
    			}
    		}
    		
    		else if (choice == 3) {
    			List[viTri].Input();
    		}
    	}
    	
    	return List;
    }

    public void search(){
        String ma;
        System.out.print("Nhap ma san pham can tim: ");
        ma = sc.nextLine();
        int count = 0, i;
        for (i=0;i<List.length;i++){
            if (ma.equals(List[i].MaSP))
            {
                System.out.println(List[i].toStringL());
                count++;
            }
            if (count==0)
                System.out.println("Khong co san pham ban tim trong kho.");
        }
    }

    public void searchH_G(){
        String brand;
        long fee1, fee2;
        System.out.print("Nhap hang san xuat cua san pham: ");
        brand = sc.nextLine();
        System.out.print("Nhap gia toi thieu cua san pham: ");
        fee1 = Long.parseLong(sc.nextLine());
        System.out.print("Nhap gia cao nhat cua san pham: ");
        fee2 = Long.parseLong(sc.nextLine());
        int count = 0;
        for (int i=0;i<n;i++)
        {
            if (brand.equals(List[i].Hang) && (fee1<=List[i].Gia && fee2>=List[i].Gia))
            {
                System.out.println(List[i].toString());
                count++;
            }
        }
        if (count == 0)
            System.out.println("Hien khong co san pham ban tim trong kho.");
    }
    public void searchTL(){
        int ch;
        Boolean key = true;
        do{
            System.out.println("1.Tim san pham theo hang san xuat va gia\n"+"2.Tim my pham theo hang va loai\n"+"3.Tim trang phuc theo gioi tinh va hang\n"+"4.Tim van phong pham theo chat lieu va doi tuong\n"+"5.Tim thuc pham theo cach che bien va gia\n"+"6.Tim thuc uong theo loai va cach dong goi");
            System.out.print("Nhap lua chon cua ban: ");
            ch = Integer.parseInt(sc.nextLine());
            switch (ch){
                case 1:
                {
                    searchH_G();
                    key = false;
                    break;
                }
                case 2:
                {
                    String brand,type;
                    System.out.print("Nhap hang san xuat cua san pham: ");
                    brand = sc.nextLine();
                    System.out.print("Nhap loai my pham: ");
                    type = sc.nextLine();
                    int count = 0;
                    for (int i=0;i<n;i++)
                    {
                        if (List[i] instanceof MyPham)
                        {
                            String brandr = List[i].Hang();
                            String Loair = List[i].Loai();
                            if (brand.equals(brandr) && type.equals(Loair))
                            {
                                System.out.println(List[i].toStringL());
                                count++;
                            }
                        }
                    }
                    if (count == 0)
                        System.out.println("Hien khong co san pham ban tim trong kho.");
                    key = false;      
                    break;         
                }
                case 3:
                {
                    String brand;
                    int sex; 
                    System.out.print("Nhap hang san xuat cua trang phuc: ");
                    brand = sc.nextLine();
                    do{
                        System.out.print("Nhap gioi tinh trang phuc (Nam: 1|Nu: 0): ");
                        sex = Integer.parseInt(sc.nextLine());
                    }while (sex!=0 && sex!=1);
                    int count = 0;
                    for (int i=0;i<n;i++)
                    {
                        if (List[i] instanceof ThoiTrang)
                        {
                            String brandr = List[i].Hang();
                            int sexr = List[i].GioiTinh();
                            if (brand.equals(brandr) && sex==sexr)
                            {
                                System.out.println(List[i].toStringL());
                                count++;
                            }
                        }
                    }
                    if (count == 0)
                        System.out.print("Hien khong co san pham ban tim trong kho.");
                    key = false;    
                    break;    
                }
                case 4:
                {
                    String material,ob;
                    System.out.print("Nhap chat lieu san pham: ");
                    material = sc.nextLine();
                    System.out.print("Nhap doi tuong su dung: ");
                    ob = sc.nextLine();
                    int count = 0;
                    for (int i=0;i<n;i++)
                    {
                        if (List[i] instanceof VPPham)
                        {
                            String mar = List[i].ChatLieu();
                            String obr = List[i].DoiTuong();
                            if (material.equals(mar) && ob.equals(obr))
                            {
                                System.out.println(List[i].toStringL());
                                count++;
                            }
                        }
                    }
                    if (count == 0)
                        System.out.print("Hien khong co san pham ban tim trong kho.");
                    key = false;    
                    break;    
                }
                case 5:
                {
                    long fee1, fee2;
                    String cb;
                    System.out.print("Nhap cach che bien: ");
                    cb = sc.nextLine();
                    System.out.print("Nhap gia khoi diem: ");
                    fee1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap gia toi da: ");
                    fee2 = Integer.parseInt(sc.nextLine());
                    int count = 0;
                    for (int i=0;i<n;i++)
                    {
                        if (List[i] instanceof ThucPham)
                        {
                            String cbr = List[i].CheBien();
                            if (cb.equals(cbr) && (fee1<=List[i].Gia && fee2>=List[i].Gia))
                            {
                                System.out.println(List[i].toStringL());
                                count++;
                            }
                        }
                    }
                    if (count == 0)
                        System.out.print("Hien khong co san pham ban tim trong kho.");
                    key = false;    
                    break;
                }
                case 6:
                {
                    String type,dg;
                    System.out.print("Nhap loai thuc uong: ");
                    type = sc.nextLine();
                    System.out.print("Nhap phuong thuc dong goi: ");
                    dg = sc.nextLine();
                    int count = 0;
                    for (int i=0;i<n;i++)
                    {
                        if (List[i] instanceof ThucUong)
                        {
                            String typer = List[i].Loai();
                            String dgr = List[i].DongGoi();
                            if (type.equals(typer) && dg.equals(dgr))
                            {
                                System.out.println(List[i].toStringL());
                                count++;
                            }
                        }
                    }
                    if (count == 0)
                        System.out.print("Hien khong co san pham ban tim trong kho.");
                    key = false;    
                    break;
                }
                default:
                {
                    System.out.println("Khong co lua chon nay, moi chon lai!");
                    break;
                }
            }
        }while(key);    
    }
}
