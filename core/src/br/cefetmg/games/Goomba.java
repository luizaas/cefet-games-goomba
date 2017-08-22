/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 *
 * @author Alberto
 */
public class Goomba {
    //private Sprite jogador;
    private Texture spriteSheet;
    private TextureRegion[][] qda;
    private Animation[] andar;
    private float tempoDaAnimacao;
    private float [] posicao;
    private int[] tam;
    private int orientacao;
    public Goomba(Texture tex) {
        this.spriteSheet=tex;
        tam=new int[2];tam[0]=21; tam[1]=24;
        this.qda = TextureRegion.split(tex, tam[0],tam[1]);
        andar= new Animation[4];
        for(int i=0;i<4;i++){
            andar[i] = new Animation(0.1f ,qda[i][0],qda[i][1],qda[i][2],qda[i][3],qda[i][4]);
            andar[i].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        }
        tempoDaAnimacao=0;
        posicao=new float[2];posicao[0]=50;posicao[1]=20;
    }
    
    /*public Goomba(Texture tex) {
        jogador = new Sprite(tex);
        jogador.setPosition(50,20);  
    }*/
    public void render(Batch batch){
        batch.draw((TextureRegion)andar[orientacao].getKeyFrame(tempoDaAnimacao), posicao[0], posicao[1]);
    }
    /*public void render(Batch batch){
       jogador.draw(batch);
    }*/
    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)&& posicao[0]>0) {
            posicao[0]--;tempoDaAnimacao+=Gdx.graphics.getDeltaTime();orientacao=3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&posicao[0]<Gdx.graphics.getWidth()-tam[0]) {
            posicao[0]++;tempoDaAnimacao+=Gdx.graphics.getDeltaTime();orientacao=1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && posicao[1]<Gdx.graphics.getHeight()-tam[1]) {
            posicao[1]++;tempoDaAnimacao+=Gdx.graphics.getDeltaTime();orientacao=2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)&&posicao[1]>0) {
            posicao[1]--;tempoDaAnimacao+=Gdx.graphics.getDeltaTime();orientacao=0;
        }
    }
    /*public void update(){
       if (Gdx.input.isKeyPressed(Input.Keys.LEFT)&& jogador.getX()>0) {
            jogador.setPosition((jogador.getX()-1), jogador.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&jogador.getX()<Gdx.graphics.getWidth()-jogador.getWidth()) {
            jogador.setPosition((jogador.getX()+1), jogador.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && jogador.getY()<Gdx.graphics.getHeight()-jogador.getHeight()) {
            jogador.setPosition(jogador.getX(),(jogador.getY()+1));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)&&jogador.getY()>0) {
            jogador.setPosition(jogador.getX(),(jogador.getY()-1));
        }
   }*/    
    
}
