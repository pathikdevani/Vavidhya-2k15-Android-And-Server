package com.spidren.api.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

public class MyPath extends Path {
	
	public void init(int width,int height){
		computeBounds(rectF, true);
		this.width = width;
		this.height = height;
	}
	
	public float width;
	public float height;
	
	
	public float scalex = 1;
	public float scaley = 1;
	
	public float x = 0;
	public float y = 0;
	
	
	
	public Matrix matrix = new Matrix(); 
	static RectF rectF = new RectF();
	
	public float getHeight(){
	
		return (scalex*height);
	}
	
	public float getWidth(){
		return (scaley*width);
	}
	
	public int getX(){
		return (int)(x);
	}
	
	public int getY(){
		return (int)(y);
	}
	
	public int getVal(float val){
		return (int)(scaley*val);
	}
	
	public void resizeScale(float scale,float x,float y) {
		scalex = scale;
		scaley = scale;
		this.x = x;
		this.y = y;
		matrix.postScale(scale,scale);
		matrix.postTranslate(x,y);
		transform(matrix);
	} 
	
	public void resizeScale(float width,float height,float x,float y) {
		scalex = width/this.height;
		scaley = height/this.width;
		this.x = x;
		this.y = y;
		matrix.postScale(scalex,scaley);
		matrix.postTranslate(x,y);
		transform(matrix);
	} 
	
	public void setPos(float x,float y){
		this.x = x;
		this.y = y;
		matrix.postTranslate(x,y);
		transform(matrix);
	}
	

	
	public void resizeWidth(float width,float x,float y) {
		
		matrix.postTranslate(x,y);
		matrix.postScale(width/this.width,width/this.width);
		transform(matrix);
	}
	
	public void heightWidth(float width,float height) {
		matrix.postTranslate(x,y);
		matrix.postScale(width/this.width,height/this.height);
		transform(matrix);
	}
	
	public void setCenter(float scale,float width,float height) {
		scalex = scale;
		scaley = scale;
		matrix.postScale(scale,scale);
		matrix.postTranslate((width-(scale*this.width))/2,(height-(scale*this.height))/2);
		transform(matrix);
	}
	
	public void setCenterHeight(float Height,float refWidth,float refHeight) {
		scalex = Height/this.height;
		scaley = scalex;
		this.x = (refHeight-(scalex*this.width))/2;
		this.y = (refWidth-(scalex*this.height))/2;
		matrix.postScale(scalex,scaley);
		matrix.postTranslate(x,y);
		transform(matrix);
	}
	
	public void rotat(int digree,int x,int y) {
		matrix.postRotate(digree, x, y);
		transform(matrix); 
	}

}
