package cz.cvut.fit.niadp.mvcgame.visitor.objectsrenderer;

public class EnemyPos {

    /*
    * TODO: Enemy positions generator for each levels
    */
    private int[][] pos = {
            {380, 59}, {500, 79}, {1180, 89},
            {780, 309}, {580, 339}, {1080, 439},
            {790, 459}
    };

    private void initializePositions(){
    }

    public int[][] getInitPos(){
        if(this.pos == null){
            this.initializePositions();
        }
        return this.pos;
    }
}
