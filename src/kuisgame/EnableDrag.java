/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.Component;

/**
 *
 * @author Rosyid Iz
 */
public class EnableDrag {
    public EnableDrag(Component c) {
        DragListener customBar = new DragListener();
        c.addMouseListener(customBar);
        c.addMouseMotionListener(customBar);
    }
}
