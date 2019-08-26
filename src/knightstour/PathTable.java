/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 *
 * @author PREOATOR
 */
public class PathTable {
    
    int N = 8;
    private static int[] cx = {1,1,2,2,-1,-1,-2,-2};
    private static int[] cy = {2,-2,1,-1,2,-2,1,-1};
    private int sx;
    private int sy;
    private int[][] a = new int[8][8];
    private int[] chessTable = new int[64];
    private AnswerPrinting ans;
    
    private boolean limits(int x,int y){
        return ((x>=0 && y>=0)&&(x < N && y < N));
    }
    private boolean isEmpty(int x,int y){
        return (limits(x,y)) && (chessTable[y*N+x]<0);
    }
    private int getDeg(int x,int y){
        int count = 0;
        for(int i = 0;i<N;++i){
            if(isEmpty((x+cx[i]),(y+cy[i]))){
                count++;
            }
        }
        return count;
    }
    private boolean nextMove(){
        int min_deg_idx = -1;
        int c;
        int min_deg = 9;
        int nx,ny;
        int st = (int)(Math.random()*10)%N;
        //System.out.println("st"+st);
        for(int count = 0;count < N;count++){
            int i = (st+count)%N;
            nx = sx+cx[i];
            ny = sy+cy[i];
            //System.out.println("----"+nx+"----"+ny);
            if((isEmpty(nx,ny)) && getDeg(nx,ny)<min_deg){
                c=getDeg(nx,ny);
                min_deg_idx = i;
                min_deg = c;
            }
            //System.out.println("****"+min_deg_idx+"****"+min_deg);
        }
        
        if(min_deg_idx == -1){
            //System.out.println("aaaaa");
            return false;
        }
        nx = sx+cx[min_deg_idx];
        ny = sy+cy[min_deg_idx];
        //System.out.println("+-+-+"+nx+"+-+-+"+ny);
        chessTable[ny*N+nx] = chessTable[sy*N+sx]+1;
        //System.out.println(chessTable[ny*N+nx]);
        int ii = ny*N+nx;
        //System.out.println("//"+ii);
        sx=nx;
        sy=ny;
        return true;
    }
    private boolean neighbor(int x,int y,int xx,int yy){
        for(int i=0;i<N;i++){
            if(((x+cx[i])==xx)&&((y+cy[i])==yy)){
                return true;
            }
        }
        return false;
    }
    private boolean findClosedTour(){
        for(int i=0;i<N*N;i++){
            chessTable[i] = -1;
        }
        int inx = sx;
        int iny = sy;
        chessTable[(iny*N)+inx] = 1;
        int ii = iny*N+inx;
        //System.out.println("+++++"+ii);
        for(int i = 0;i<63;i++){
            if(nextMove()==false){
                //System.out.println("uuuuuuuuuuuu");
                return false;
            }
        }
        if(!neighbor(sx,sy,inx,iny)){
            //System.out.println("gggggg");
            return false;
        }
        return true;
    }
    public PathTable(int x, int y, Table t) {
        sx=x;
        sy=y;
        while(!findClosedTour()){
            sx=x;
            sy=y;
        }
        printChessTable();
        t.dispose();
        ans = new AnswerPrinting(a);
        ans.setVisible(true);
    }

    private void printChessTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a[i][j]=chessTable[j*N+i];
                System.out.print("\t" + chessTable[j*N+i]);
            }
            System.out.println();
        }
        System.out.println("   --------------------------------------------------------------------");
    }
}
