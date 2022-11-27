package minimarket;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

class KhachHang{
    private String Hoten;
    private String SDT;
    private int MaKH=0;
    private static int countUP=0;
    Scanner sc=new Scanner(System.in);

    public KhachHang(){
        countUP++;
        MaKH=countUP;
    }

    public KhachHang(String Hoten,String SDT)
    {
        this.Hoten=Hoten;
        this.SDT=SDT;
        countUP++;
        MaKH=countUP;
    }

    public int getMaKH(){
        return MaKH;
    }

    public String getHoten(){
        return Hoten;
    }
    
    public void setHoten(String Hoten){
        this.Hoten=Hoten;
    } 

    public String getSDT(){
        return SDT;
    }
    
    public void setSDT(String SDT){
        this.SDT=SDT;
    }

    public void input(){
        System.out.print("Hay nhap ho va ten : ");
        Hoten=sc.nextLine();
        System.out.print("Hay nhap so dien thoai : ");
        SDT=sc.nextLine();
    }

}

class Don{
    String MaSP;
    String Ten;
    int SL;
    long gt;
    long tt;
    Scanner sc=new Scanner(System.in);

    public Don(){};

    public Don(String MaSP,String Ten,int SL,long gt){
        this.MaSP=MaSP;
        this.Ten=Ten;
        this.SL=SL;
        this.gt=gt;
        this.tt=SL*gt;
    }

    public String setMaSP(){
        return MaSP;
    }

    public void getMaSP(String MaSP){
        this.MaSP=MaSP;
    }

    public String setTen(){
        return Ten;
    }

    public void getTen(String Ten){
        this.Ten=Ten;
    }

    public int setSL(){
        return SL;   
    }

    public void getSL(int SL){
        this.SL=SL;
    }

    public long setGT(){
        return gt;
    }

    public void getGT(long gt){
        this.gt=gt;
    }

    public long setTT(){
        return tt;
    }

    public void getTT(long tt){
        this.tt=tt;
    }
}

public class GioHang{
    KhachHang Cus;
    Nhancong Emp;
    int n;
    Don List[];
    int MaHĐ;
    private static int countUP=0;
    long Total;
    java.util.Date Date;
    Scanner sc=new Scanner(System.in);

    public GioHang(){
        Cus=new KhachHang();
        Emp=new NhanVien();
        Date=new java.util.Date();
        Total=0;
        countUP++;
        MaHĐ=countUP;
    }

    public GioHang(KhachHang Cus,int n,Don List[]){
        this.Cus=Cus;
        this.n=n;
        this.List=List;
        countUP++;
        MaHĐ=countUP;
    }

    public KhachHang getCus(){
        return Cus;
    }

    public void setCus(KhachHang Cus){
        this.Cus=Cus;
    }

    public int setn(){
        return n;
    }

    public void getn(int n){
        this.n=n;
    }

    public Don[] getList(){
        return List;
    }

    public void setList(Don[] List){
        this.List=List;
    }

    public void HoaDon(){
        int i;
        Total=0;
        System.out.println("            SIEU THI MINI TURMERIC            ");
        System.out.println();
        System.out.println("   286A AN DUONG VUONG , PHUONG 4, QUAN 5     ");
        System.out.println("  TEL: +84-28-38300983 FAX: +84-28-38300983   ");
        System.out.println("                HOA DON BAN HANG              ");
        System.out.printf("        SO HOA DON : %d \n",MaHĐ);
        System.out.println("||==========================================||");
        System.out.println("TEN SAN PHAM");
        System.out.printf("%-10s%-6s%-15s%-15s\n","MA HANG","SL","DON GIA","THANH TIEN");
        for(i=0;i<List.length;i++)
        {
            System.out.printf("%s\n",List[i].Ten);
            System.out.printf("%-10s%-6s%-15s%-15s\n",List[i].MaSP,List[i].SL,List[i].gt,List[i].tt);
            Total=Total+List[i].tt;
        }
        System.out.println("||==========================================||");
        System.out.printf("TONG THANH TOAN: %d\n",Total);
        System.out.println("||==========================================||");
        System.out.println("XIN CAM ON QUY KHACH!");
        System.out.printf("THU NGAN: %s\n",Emp.getTen());
        System.out.print("NGAY: ");System.out.println(Date);
        System.out.println();
    }

    public void printHD(){
        int i;
        Total=0;
        try{
            FileWriter fw=new FileWriter("HD.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("            SIEU THI MINI TURMERIC            \n\n");
            bw.write("   286A AN DUONG VUONG , PHUONG 4, QUAN 5     \n");
            bw.write("  TEL: +84-28-38300983 FAX: +84-28-38300983   \n");
            bw.write("                HOA DON BAN HANG              \n");
            bw.write("        SO HOA DON : "+MaHĐ);
            bw.write("\n||==========================================||\n");
            bw.write("TEN SAN PHAM\n");
            bw.write("MA HANG\t"+"SL\t"+"DON GIA\t"+"THANH TIEN\n");
            for(i=0;i<List.length;i++)
            {
                bw.write(List[i].Ten+"\n");
                bw.write(List[i].MaSP+" \t"+List[i].SL+"\t"+List[i].gt+"\t"+List[i].tt+"\n");
                Total=Total+List[i].tt;
            }
            bw.write("||==========================================||\n");
            bw.write("TONG THANH TOAN: "+Total+"\n");
            bw.write("||==========================================||\n");
            bw.write("THU NGAN: "+Emp.getTen()+"\n");
            bw.write("NGAY: "+Date);
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class GioHangList{
    int n;
    GioHang List[];
    long Total=0;
    Scanner sc=new Scanner(System.in);

    public GioHangList(){
        List=new GioHang[0];
    }

    public GioHang[] input(GioHang a){
        GioHang Copied[]=new GioHang[n+1];
        for(int i=0;i<List.length;i++)
        {
            Copied[i]=List[i];
        }
        Copied[List.length]=a;
        n=n+1;
        return Copied;
    }

    public void setDefault(){
        List= new GioHang[3];
        n=3;
        Don defDon1[]=new Don[1];
        defDon1[0]=new Don("MP001","Son mong tay Felina Deluxe DS548 16ml",3,30000); 
        Don defDon2[]=new Don[2];
        defDon2[0]=new Don("TP001","Banh ngu coc an sang Kellogg's Frosties 175g",1,58600);
        defDon2[1]=new Don("PP003","Bia 2 nut F4,31102020",4,21600);
        Don defDon3[]=new Don[2];
        defDon3[0]=new Don("PP003","Bia 2 nut F4,31102020",2,21600);
        defDon3[1]=new Don("PP002","Tui cai ho so khoa keo luoi A4",2,18900);
        KhachHang defKH[]= new KhachHang[3];
        defKH[0]=new KhachHang("Hanzo Hasashi","6666666666");
        defKH[1]=new KhachHang("Kuai Liang","0007770007");
        defKH[2]=new KhachHang("Bi Han","9999999999");
        java.util.Date Date=new java.util.Date();
        ListNhanCong objNC=new ListNhanCong();
        objNC.readFILE();
        List[0]=new GioHang(defKH[0],1,defDon1);
        List[1]=new GioHang(defKH[1],2,defDon2);
        List[2]=new GioHang(defKH[2],2,defDon3);
        List[0].Date=Date;
        List[1].Date=Date;
        List[2].Date=Date;
        List[0].Emp=objNC.randomTN();
        List[1].Emp=objNC.randomTN();
        List[2].Emp=objNC.randomTN();
        List[0].Total=90000;
        List[1].Total=145000;
        List[2].Total=81000;
    }

    public void ThongKeDH(){
        int i;
        System.out.printf("%-10s %-50s %-20s\n","Ma don","Thoi gian than toan","Thanh tien");
        for(i=0;i<List.length;i++)
        {
            System.out.printf("%-10s %-50s %-20s\n",List[i].MaHĐ,List[i].Date,List[i].Total);
            Total=Total+List[i].Total;
        }
        System.out.println("||===========================================================||");
        System.out.printf("Tong danh thu: %d\n",Total);
    }

    public void ThongKeKH(){
        int i;
        System.out.printf("%-10s %-20s %-20s %-50s\n","Ma khach","Ho va ten","So dien thoai","Thoi gian mua hang");
        for(i=0;i<List.length;i++)
        {
            System.out.printf("%-10d %-20s %-20s %-50s\n",List[i].Cus.getMaKH(),List[i].Cus.getHoten(),List[i].Cus.getSDT(),List[i].Date);
        }
    }

    public void Chose(){
        int i,temp=-1;
        while(true){
            System.out.print("Hay chon ma so khach hang muon lay hoa don : ");
            int k=Integer.parseInt(sc.nextLine());
            k=k-1;
            for(i=0;i<List.length;i++)
            {
                if(List[i].Cus.getMaKH()==k)
                {
                    temp=k;
                    break;
                }
            }
            if(temp!=-1) {break;}
            else {System.out.println("Ma so vua nhap khong ton tai vui long nhap lai !");}      
        }
        List[temp].printHD();
    }
}
