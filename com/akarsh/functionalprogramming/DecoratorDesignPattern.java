package com.akarsh.functionalprogramming;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

class Camera{

    private Function<Color, Color> filter;
    public Camera(){
        setFilter();
    }

    public void setFilter(Function<Color, Color> ...filters) {
        this.filter = Stream.of(filters)
                .reduce(Function::compose)
                .orElse(color -> color);
    }

    public Color capture(Color color){
        return this.filter.apply(color);
    }

}


public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Color capturedColor = camera.capture(new Color(255, 255, 255, 255));
        System.out.println(capturedColor);

        camera.setFilter(Color::darker);
        capturedColor = camera.capture(new Color(255, 255, 255, 255));
        System.out.println(capturedColor);

        camera.setFilter(Color::darker, Color::brighter);
        capturedColor = camera.capture(new Color(125, 125, 125, 122));
        System.out.println(capturedColor);

        camera.setFilter(color -> new Color(color.getRed(), 0,color.getBlue()), Color::darker);
        capturedColor = camera.capture(new Color(125, 125, 125, 122));
        System.out.println(capturedColor);
    }
}
