/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Rosyid Iz
 */
public class DragListener extends MouseInputAdapter {
    Point location;
    MouseEvent pressed;
    
    @Override
    public void mousePressed(MouseEvent me){
        pressed = me;
    }
    @Override
    public void mouseDragged(MouseEvent me){
        Component comp = me.getComponent();
        location = comp.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        comp.setLocation(x, y);
    }
}
