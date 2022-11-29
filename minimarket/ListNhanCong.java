package minimarket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class ListNhanCong implements subMenu{
	private int n;
    Nhancong List[];
    private static String readF="NC_R.txt";
    private static String writeF="NC_W.txt";
    Scanner sc=new Scanner(System.in);

    public int Getn(){
        return n;
    }

    public void Setn(int n){
        this.n=n;
    }

    public Nhancong[] getList(){
        return List;
    }

    public void setList(Nhancong[] List){
        this.List=List;
    }

    public void input_List(){
        System.out.println("Hay nhap so luong nhan cong :");
        n=Integer.parseInt(sc.nextLine());
        List=new Nhancong[n];
        int choice;
        boolean flag=true;
        for(int i=0;i<n;i++){
            System.out.printf("Hay nhap nhan cong thu %d : \n",i+1);
            System.out.println("1.Quan Ly\n"+"2.Nhan Vien\n");
            System.out.print("Hay chon kieu nhan cong muon them :");
            choice=Integer.parseInt(sc.nextLine());
            do
            {
            switch (choice) {
                case 1:
                {
                    List[i]=new QuanLy();
                    List[i].Input();
                    flag=false;
                    break;
                }
                case 2:
                {
                    List[i]=new NhanVien();
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

    public void output_ListQL(){
        System.out.println("Danh sach cac quan ly : ");
        System.out.printf("%-10s %-20s %-20s %-19s %-20s %-20s %s \n","Ma","Ten","SDT","Ngay BD","Kinh nghiem","So ngay nghi","Luong");
        for(int i=0;i<List.length;i++)
        {
            if(List[i] instanceof QuanLy)
            {
               System.out.println(List[i].toString());;
            }
        }
    }

    public void output_ListNV(){
        System.out.println("Danh sach cac nhan vien : ");
        System.out.printf("%-10s %-20s %-20s %-19s %-15s %-20s %-15s \n","Ma","Ten","SDT","Ngay BD","Luong","Ca","Vai tro");
        for(int i=0;i<List.length;i++)
        {
            if(List[i] instanceof NhanVien)
            {
            	System.out.println(List[i].toString());;
            }
        }
    }

    public void output_List(){
        System.out.println("Danh sach toan bo nhan cong : ");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s \n","Ma","Ten","SDT","Ngay BD","Luong");
        for(int i=0;i<List.length;i++)
        {
            System.out.println(List[i].toString());
        }
    }

    public Nhancong[] AddList1(){
        int choice;
        Nhancong a = new Nhancong() {
            public long Luong(){
                return 0;
            }
        };
        boolean flag=true;
        System.out.println("1.Quan ly\n"+"2.Nhan vien\n");
        System.out.print("Hay chon kieu nhan cong muon them :");
        choice=Integer.parseInt(sc.nextLine());
        do
        {
        switch (choice) {
        case 1:
            {
                a=new QuanLy();
                a.Input();
                flag=false;
                break;
            }
        case 2:
            {
                a=new NhanVien();
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
        Nhancong Copied[]=new Nhancong[List.length+1];
        for(int i=0;i<List.length;i++)
        {
            Copied[i]=List[i];
        }
        Copied[List.length]=a;
        n=n+1;
        System.out.println("Them nhan cong thanh cong !");
        return Copied;
    }

    public Nhancong[] AddListn(){
        int i,k,choice;
        while(true){
            System.out.println("Nhap so nhan cong can them :");
            k=Integer.parseInt(sc.nextLine());
            if(k>0) break;
            System.out.println("Nhap khong hop le vui long nhap lai");
        }
        Nhancong Copied[]=new Nhancong[List.length+k];
        for(i=0;i<List.length;i++)
        {
            Copied[i]=List[i];
        }
        int t=List.length;
        for(i=0;i<k;i++)
        {
            System.out.printf("Nhap thong tin cua nhan cong thu %d can them: \n",i+1);
            Nhancong a=new Nhancong() {
                public long Luong(){
                    return 0;
                }
            };
            boolean flag=true;
            System.out.println("1.Quan ly\n"+"2.Nhan vien\n");
            System.out.print("Hay chon lai nhan cong muon them :");
            choice=Integer.parseInt(sc.nextLine());
            do
            {
            switch (choice) {
            case 1:
                {
                    a=new QuanLy();
                    a.Input();
                    flag=false;
                    break;
                }
            case 2:
                {
                    a=new NhanVien();
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
        System.out.println("Them nhan cong thanh cong !");
        return Copied;
    }

    public Nhancong[] Delete(){
        int i,temp=-1;
        String ma;
        while(true){
            System.out.println("Nhap ma so san pham can xoa :");
            ma=sc.nextLine();
            for(i=0;i<List.length;i++)
            {
            if(ma.equals(List[i].MaNC)){
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
        Nhancong Copied[]=new Nhancong[List.length-1];
        for(i=0;i<temp;i++)
        {
            Copied[i]=List[i];
        }
        for(i=temp+1;i<List.length;i++)
        {
            Copied[i-1]=List[i];
        }
        n=n-1;
        System.out.println("Xoa nhan cong thanh cong !");
        return Copied;
    }

    public void search()
    {
        String id;
        System.out.print("Nhap ma nhan cong can tim: ");
        id = sc.nextLine();
        int count = 0;
        for (int i=0;i<List.length;i++)
        {
            if (id.equals(List[i].MaNC))
            {
                System.out.print(List[i].toString());
                count++;    
            }
        }
        if (count == 0)
            System.out.println("Khong co nguoi nay trong danh sach nhan su.");
    }

    public Nhancong[] adjust() {
    	boolean flag=false;
    	boolean kiemTraMaTonTai;
    	byte choice=0;
    	int viTri=0;
    	String maTimKiem = "";
    	do {
    		kiemTraMaTonTai=false;
    		System.out.print("Nhap ma nhan cong can tim : ");
        	maTimKiem = sc.nextLine();
        	for(int i=0;i<List.length;i++) {
        		if (maTimKiem.equals(List[i].getMaNC())) {
        			viTri = i;
        			flag = true;
        		}
        	}
        	if ((!maTimKiem.substring(0,2).equals("NV") || !maTimKiem.substring(0,2).equals("QL")) && maTimKiem.substring(2).length()!=3 || !flag) 
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
    		System.out.println("2. Thong tin rieng cua nhan cong");
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
    			System.out.print("\nThay doi ten? :");
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ten nhan cong : ");
    				List[viTri].setTen(sc.nextLine());
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi ma nhan cong? :"); // Doi NXS
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ma nhan cong : ");
    				List[viTri].setMaNC(sc.nextLine());;
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi ngay bat dau? :"); // Doi han su dung
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap ngay bat dau : ");
    				List[viTri].getNgayBD().inputDATE();;
    				luaChon = 0;
    			}
    			
    			System.out.print("\nThay doi SDT? :"); // Doi ten hang
    			luaChon = Byte.parseByte(sc.nextLine());
    			if (luaChon == 1) {
    				System.out.print("Hay nhap SDT : ");
    				List[viTri].setSDT(sc.nextLine());
    				luaChon = 0;
    			}

    		}
    		else if (choice == 2) {
    			byte luaChon=0;
    			System.out.println("\n1. Thay doi || Other. Khong thay doi");
    			
    			if (List[viTri] instanceof NhanVien) { // MỸ PHẨM
    				System.out.print("\nThay doi so ca? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap so ca : ");
        				((NhanVien) List[viTri]).setCa(Integer.parseInt(sc.nextLine()));
        			}
        			System.out.print("\nThay doi vai tro? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        				System.out.print("Hay nhap vai tro : ");
        				((NhanVien) List[viTri]).setVaiTro(sc.nextLine());
        			}
    			}
    			else if (List[viTri] instanceof QuanLy) { //THỜI TRANG
    				System.out.print("\nThay doi so thang da lam? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        		        System.out.println("Hay nhap so thang da lam : ");
        		        ((QuanLy) List[viTri]).setKinhNghiem(Integer.parseInt(sc.nextLine()));
        			}
        			System.out.print("\nThay doi so ngay nghi trong thang? :");
        			luaChon = Byte.parseByte(sc.nextLine());
        			if (luaChon == 1) {
        		        System.out.println("Hay nhap so ngay nghi trong thang : ");
        		        ((QuanLy) List[viTri]).setRest(Integer.parseInt(sc.nextLine()));
        			}
    			}
    			
    		}
    		
    		else if (choice == 3) {
    			List[viTri].Input();
    		}
    	}
    	
    	return List;
    }

    public void readFILE(){
        try{
            FileReader fp = new FileReader(readF);
            BufferedReader br = new BufferedReader(fp);
            String line="";
            line = br.readLine();
            String tmp[] = line.split(" ");
            n = Integer.parseInt(tmp[1]);
            //n = count;
            int d,m,y,i=0;
            List = new Nhancong[n];
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String txt[] = line.split(",");
                String ID = txt[0];
                String Name = txt[1];
                String SDT = txt[2];
                String NBD = txt[3];
                d=Integer.parseInt(NBD.substring(0,2));
                m=Integer.parseInt(NBD.substring(2,4));
                y=Integer.parseInt(NBD.substring(4));
                Date NgayBD= new Date(d,m,y);
                if(ID.substring(0,2).equals("QL"))
                {
                    String KinhNghiem = txt[4];
                    String rest = txt[5];
                    List[i] = new QuanLy(ID,Name,SDT,NgayBD,Integer.parseInt(KinhNghiem),Integer.parseInt(rest));
                }
                if(ID.substring(0,2).equals("NV"))
                {
                    String ca = txt[4];
                    String vaiTro = txt[5];
                    List[i] = new NhanVien(ID,Name,SDT,NgayBD,Integer.parseInt(ca),vaiTro);
                }
                i++;
            }
            br.close();
            fp.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void rewriteFILE(){
        int i;
        try{
            FileWriter fw = new FileWriter(readF);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("SL: "+List.length);
            for(i=0;i<List.length;i++)
            {
                bw.write("\n"+List[i].toStringRE());
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Nhancong randomTN()
    {
        Nhancong nv = new NhanVien();
        Random rand = new Random();
        int flag = 1;
        do {
            int key = rand.nextInt(n);
            if (List[key] instanceof NhanVien){
                nv = List[key];
                flag = 0;
                break;
            }
        }while(flag == 1);
        return nv;
    }

    public void writeFILE(){
        try{
            FileWriter fw = new FileWriter(writeF);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\tDanh sach nhan cong : \n\n");
            bw.write(String.format("%-10s %-20s %-20s %-20s\n","Ma","Ten","SDT","Ngay bat dau lam"));
            for(int i=0;i<List.length;i++)
            {
                bw.write(List[i].toStringL());
                bw.newLine();
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach Quan ly: \n\n");
            bw.write(String.format("%-10s %-20s %-20s %-20s %-15s %-20s %-20s\n","Ma","Ten","SDT","Ngay bat dau lam","Kinh nghiem","So ngay nghi","Luong"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof QuanLy){
                    bw.write(List[i].toString());
                    bw.newLine();
                }
            }
            bw.newLine();
            bw.newLine();
            bw.write("\tDanh sach nhan vien: \n\n");
            bw.write(String.format("%-10s %-20s %-20s %-20s %-15s %-20s %-20s\n","Ma","Ten","SDT","Ngay bat dau lam","So ca lam","Vai tro","Luong"));
            for(int i=0;i<List.length;i++)
            {
                if(List[i] instanceof NhanVien){
                    bw.write(List[i].toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Thong ke
    public void ThongKe(){
        long luong=0, luongnv=0, luongql=0, rest=0, ca=0,k=0,j=0;
        for (int i=0;i<List.length;i++)
        {
            luong += List[i].Luong();
            if (List[i] instanceof QuanLy){
                rest += ((QuanLy)List[i]).getRest();
                luongql += ((QuanLy)List[i]).Luong();
                k++;
            }
            if (List[i] instanceof NhanVien)
            {
                ca += ((NhanVien)List[i]).getCa();
                luongnv += ((NhanVien)List[i]).Luong();  
                j++;
            }  
        }
        System.out.printf("%-20s %10s %25s %35s %35s\n","Luong TB","Luong TB quan li","Luong TB nhan vien","So ngay nghi TB quan li","So ca lam TB nhan vien");
        System.out.printf("%-20s %10s %25s %35s %35s\n",luong/n,luongql/k,luongnv/j,rest/k,ca/j);
    }

}
