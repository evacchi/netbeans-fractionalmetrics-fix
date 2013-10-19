/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nowhereland.fractionalmetricsenabler;

import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        Map<Object,Object> desktopHints = new HashMap<Object,Object>();
        desktopHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        Class toolkitClass = Toolkit.class;
        try {
            Method setDesktopPropertyMethod = toolkitClass.getDeclaredMethod("setDesktopProperty", new Class[]{String.class, Object.class});
            setDesktopPropertyMethod.setAccessible(true);
            setDesktopPropertyMethod.invoke(Toolkit.getDefaultToolkit(), "awt.font.desktophints", (Object)desktopHints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        
    }

}
