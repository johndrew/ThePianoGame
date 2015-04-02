/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import thepianogame.models.Piano;

public class PianoView extends JPanel {
 
    public PianoView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    
        JLayeredPane pianoPane = new javax.swing.JLayeredPane();
        this.setLayout(new BorderLayout());
        this.add(pianoPane, BorderLayout.CENTER);
        JPanel b1 = new javax.swing.JPanel();
        JPanel c1 = new javax.swing.JPanel();
        JPanel csharp1 = new javax.swing.JPanel();
        JPanel d1 = new javax.swing.JPanel();
        JPanel dsharp1 = new javax.swing.JPanel();
        JPanel e1 = new javax.swing.JPanel();
        JPanel f1 = new javax.swing.JPanel();
        JPanel fsharp1 = new javax.swing.JPanel();
        JPanel g1 = new javax.swing.JPanel();
        JPanel gsharp1 = new javax.swing.JPanel();
        JPanel a1 = new javax.swing.JPanel();
        JPanel asharp1 = new javax.swing.JPanel();
        JPanel b2 = new javax.swing.JPanel();
        JPanel c2 = new javax.swing.JPanel();
        JPanel csharp2 = new javax.swing.JPanel();
        JPanel d2 = new javax.swing.JPanel();
        JPanel dsharp2 = new javax.swing.JPanel();
        JPanel e2 = new javax.swing.JPanel();
        JPanel f2 = new javax.swing.JPanel();
        JPanel fsharp2 = new javax.swing.JPanel();
        JPanel g2 = new javax.swing.JPanel();
        JPanel gsharp2 = new javax.swing.JPanel();
        JPanel a2 = new javax.swing.JPanel();
        JPanel asharp2 = new javax.swing.JPanel();
        JPanel b3 = new javax.swing.JPanel();
        JPanel middleC = new javax.swing.JPanel();
        JPanel csharp3 = new javax.swing.JPanel();
        JPanel d3 = new javax.swing.JPanel();
        JPanel dsharp3 = new javax.swing.JPanel();
        JPanel e3 = new javax.swing.JPanel();
        JPanel f3 = new javax.swing.JPanel();
        JPanel fsharp3 = new javax.swing.JPanel();
        JPanel g3 = new javax.swing.JPanel();
        JPanel gsharp3 = new javax.swing.JPanel();
        JPanel a3 = new javax.swing.JPanel();
        JPanel asharp3 = new javax.swing.JPanel();
        JPanel b4 = new javax.swing.JPanel();
        JPanel c4 = new javax.swing.JPanel();
        JPanel csharp4 = new javax.swing.JPanel();
        JPanel d4 = new javax.swing.JPanel();
        JPanel dsharp4 = new javax.swing.JPanel();
        JPanel e4 = new javax.swing.JPanel();
        JPanel f4 = new javax.swing.JPanel();
        JPanel fsharp4 = new javax.swing.JPanel();
        JPanel g4 = new javax.swing.JPanel();
        JPanel gsharp4 = new javax.swing.JPanel();
        JPanel a4 = new javax.swing.JPanel();
        JPanel asharp4 = new javax.swing.JPanel();
        JPanel b5 = new javax.swing.JPanel();
        JPanel c5 = new javax.swing.JPanel();
        JPanel csharp5 = new javax.swing.JPanel();
        JPanel d5 = new javax.swing.JPanel();
        JPanel dsharp5 = new javax.swing.JPanel();
        JPanel e5 = new javax.swing.JPanel();
        
        
        pianoPane.setBackground(new java.awt.Color(255, 255, 255));
        pianoPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pianoPane.setLayout(new java.awt.GridBagLayout());
        
        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(b1, new java.awt.GridBagConstraints());

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        csharp1.setBackground(new java.awt.Color(0, 0, 0));
        csharp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout csharp1Layout = new javax.swing.GroupLayout(csharp1);
        csharp1.setLayout(csharp1Layout);
        csharp1Layout.setHorizontalGroup(
            csharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        csharp1Layout.setVerticalGroup(
            csharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(csharp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        c1Layout.setVerticalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c1Layout.createSequentialGroup()
                .addComponent(csharp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(c1, new java.awt.GridBagConstraints());

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dsharp1.setBackground(new java.awt.Color(0, 0, 0));
        dsharp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout dsharp1Layout = new javax.swing.GroupLayout(dsharp1);
        dsharp1.setLayout(dsharp1Layout);
        dsharp1Layout.setHorizontalGroup(
            dsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        dsharp1Layout.setVerticalGroup(
            dsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsharp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d1Layout.setVerticalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d1Layout.createSequentialGroup()
                .addComponent(dsharp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(d1, new java.awt.GridBagConstraints());

        e1.setBackground(new java.awt.Color(255, 255, 255));
        e1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout e1Layout = new javax.swing.GroupLayout(e1);
        e1.setLayout(e1Layout);
        e1Layout.setHorizontalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        e1Layout.setVerticalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(e1, new java.awt.GridBagConstraints());

        f1.setBackground(new java.awt.Color(255, 255, 255));
        f1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fsharp1.setBackground(new java.awt.Color(0, 0, 0));
        fsharp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout fsharp1Layout = new javax.swing.GroupLayout(fsharp1);
        fsharp1.setLayout(fsharp1Layout);
        fsharp1Layout.setHorizontalGroup(
            fsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        fsharp1Layout.setVerticalGroup(
            fsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1);
        f1.setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fsharp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        f1Layout.setVerticalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f1Layout.createSequentialGroup()
                .addComponent(fsharp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(f1, new java.awt.GridBagConstraints());

        g1.setBackground(new java.awt.Color(255, 255, 255));
        g1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        gsharp1.setBackground(new java.awt.Color(0, 0, 0));
        gsharp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout gsharp1Layout = new javax.swing.GroupLayout(gsharp1);
        gsharp1.setLayout(gsharp1Layout);
        gsharp1Layout.setHorizontalGroup(
            gsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        gsharp1Layout.setVerticalGroup(
            gsharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout g1Layout = new javax.swing.GroupLayout(g1);
        g1.setLayout(g1Layout);
        g1Layout.setHorizontalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gsharp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        g1Layout.setVerticalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g1Layout.createSequentialGroup()
                .addComponent(gsharp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(g1, new java.awt.GridBagConstraints());

        a1.setBackground(new java.awt.Color(255, 255, 255));
        a1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        asharp1.setBackground(new java.awt.Color(0, 0, 0));
        asharp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout asharp1Layout = new javax.swing.GroupLayout(asharp1);
        asharp1.setLayout(asharp1Layout);
        asharp1Layout.setHorizontalGroup(
            asharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        asharp1Layout.setVerticalGroup(
            asharp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout a1Layout = new javax.swing.GroupLayout(a1);
        a1.setLayout(a1Layout);
        a1Layout.setHorizontalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asharp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        a1Layout.setVerticalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a1Layout.createSequentialGroup()
                .addComponent(asharp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(a1, new java.awt.GridBagConstraints());

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        b2Layout.setVerticalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(b2, new java.awt.GridBagConstraints());

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        csharp2.setBackground(new java.awt.Color(0, 0, 0));
        csharp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout csharp2Layout = new javax.swing.GroupLayout(csharp2);
        csharp2.setLayout(csharp2Layout);
        csharp2Layout.setHorizontalGroup(
            csharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        csharp2Layout.setVerticalGroup(
            csharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(csharp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        c2Layout.setVerticalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c2Layout.createSequentialGroup()
                .addComponent(csharp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(c2, new java.awt.GridBagConstraints());

        d2.setBackground(new java.awt.Color(255, 255, 255));
        d2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dsharp2.setBackground(new java.awt.Color(0, 0, 0));
        dsharp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout dsharp2Layout = new javax.swing.GroupLayout(dsharp2);
        dsharp2.setLayout(dsharp2Layout);
        dsharp2Layout.setHorizontalGroup(
            dsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        dsharp2Layout.setVerticalGroup(
            dsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsharp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d2Layout.setVerticalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d2Layout.createSequentialGroup()
                .addComponent(dsharp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(d2, new java.awt.GridBagConstraints());

        e2.setBackground(new java.awt.Color(255, 255, 255));
        e2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout e2Layout = new javax.swing.GroupLayout(e2);
        e2.setLayout(e2Layout);
        e2Layout.setHorizontalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        e2Layout.setVerticalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(e2, new java.awt.GridBagConstraints());

        f2.setBackground(new java.awt.Color(255, 255, 255));
        f2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fsharp2.setBackground(new java.awt.Color(0, 0, 0));
        fsharp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout fsharp2Layout = new javax.swing.GroupLayout(fsharp2);
        fsharp2.setLayout(fsharp2Layout);
        fsharp2Layout.setHorizontalGroup(
            fsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        fsharp2Layout.setVerticalGroup(
            fsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2);
        f2.setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fsharp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        f2Layout.setVerticalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f2Layout.createSequentialGroup()
                .addComponent(fsharp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(f2, new java.awt.GridBagConstraints());

        g2.setBackground(new java.awt.Color(255, 255, 255));
        g2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        gsharp2.setBackground(new java.awt.Color(0, 0, 0));
        gsharp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout gsharp2Layout = new javax.swing.GroupLayout(gsharp2);
        gsharp2.setLayout(gsharp2Layout);
        gsharp2Layout.setHorizontalGroup(
            gsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        gsharp2Layout.setVerticalGroup(
            gsharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout g2Layout = new javax.swing.GroupLayout(g2);
        g2.setLayout(g2Layout);
        g2Layout.setHorizontalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gsharp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        g2Layout.setVerticalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g2Layout.createSequentialGroup()
                .addComponent(gsharp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(g2, new java.awt.GridBagConstraints());

        a2.setBackground(new java.awt.Color(255, 255, 255));
        a2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        asharp2.setBackground(new java.awt.Color(0, 0, 0));
        asharp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout asharp2Layout = new javax.swing.GroupLayout(asharp2);
        asharp2.setLayout(asharp2Layout);
        asharp2Layout.setHorizontalGroup(
            asharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        asharp2Layout.setVerticalGroup(
            asharp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asharp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        a2Layout.setVerticalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a2Layout.createSequentialGroup()
                .addComponent(asharp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(a2, new java.awt.GridBagConstraints());

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(b3, new java.awt.GridBagConstraints());

        middleC.setBackground(new java.awt.Color(255, 255, 255));
        middleC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        csharp3.setBackground(new java.awt.Color(0, 0, 0));
        csharp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout csharp3Layout = new javax.swing.GroupLayout(csharp3);
        csharp3.setLayout(csharp3Layout);
        csharp3Layout.setHorizontalGroup(
            csharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        csharp3Layout.setVerticalGroup(
            csharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout middleCLayout = new javax.swing.GroupLayout(middleC);
        middleC.setLayout(middleCLayout);
        middleCLayout.setHorizontalGroup(
            middleCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, middleCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(csharp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        middleCLayout.setVerticalGroup(
            middleCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middleCLayout.createSequentialGroup()
                .addComponent(csharp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(middleC, new java.awt.GridBagConstraints());

        d3.setBackground(new java.awt.Color(255, 255, 255));
        d3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dsharp3.setBackground(new java.awt.Color(0, 0, 0));
        dsharp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout dsharp3Layout = new javax.swing.GroupLayout(dsharp3);
        dsharp3.setLayout(dsharp3Layout);
        dsharp3Layout.setHorizontalGroup(
            dsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        dsharp3Layout.setVerticalGroup(
            dsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d3Layout = new javax.swing.GroupLayout(d3);
        d3.setLayout(d3Layout);
        d3Layout.setHorizontalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsharp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d3Layout.setVerticalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d3Layout.createSequentialGroup()
                .addComponent(dsharp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(d3, new java.awt.GridBagConstraints());

        e3.setBackground(new java.awt.Color(255, 255, 255));
        e3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout e3Layout = new javax.swing.GroupLayout(e3);
        e3.setLayout(e3Layout);
        e3Layout.setHorizontalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        e3Layout.setVerticalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(e3, new java.awt.GridBagConstraints());

        f3.setBackground(new java.awt.Color(255, 255, 255));
        f3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fsharp3.setBackground(new java.awt.Color(0, 0, 0));
        fsharp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout fsharp3Layout = new javax.swing.GroupLayout(fsharp3);
        fsharp3.setLayout(fsharp3Layout);
        fsharp3Layout.setHorizontalGroup(
            fsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        fsharp3Layout.setVerticalGroup(
            fsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout f3Layout = new javax.swing.GroupLayout(f3);
        f3.setLayout(f3Layout);
        f3Layout.setHorizontalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fsharp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        f3Layout.setVerticalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f3Layout.createSequentialGroup()
                .addComponent(fsharp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(f3, new java.awt.GridBagConstraints());

        g3.setBackground(new java.awt.Color(255, 255, 255));
        g3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        gsharp3.setBackground(new java.awt.Color(0, 0, 0));
        gsharp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout gsharp3Layout = new javax.swing.GroupLayout(gsharp3);
        gsharp3.setLayout(gsharp3Layout);
        gsharp3Layout.setHorizontalGroup(
            gsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        gsharp3Layout.setVerticalGroup(
            gsharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout g3Layout = new javax.swing.GroupLayout(g3);
        g3.setLayout(g3Layout);
        g3Layout.setHorizontalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gsharp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        g3Layout.setVerticalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g3Layout.createSequentialGroup()
                .addComponent(gsharp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(g3, new java.awt.GridBagConstraints());

        a3.setBackground(new java.awt.Color(255, 255, 255));
        a3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        asharp3.setBackground(new java.awt.Color(0, 0, 0));
        asharp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout asharp3Layout = new javax.swing.GroupLayout(asharp3);
        asharp3.setLayout(asharp3Layout);
        asharp3Layout.setHorizontalGroup(
            asharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        asharp3Layout.setVerticalGroup(
            asharp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout a3Layout = new javax.swing.GroupLayout(a3);
        a3.setLayout(a3Layout);
        a3Layout.setHorizontalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asharp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        a3Layout.setVerticalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a3Layout.createSequentialGroup()
                .addComponent(asharp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(a3, new java.awt.GridBagConstraints());

        b4.setBackground(new java.awt.Color(255, 255, 255));
        b4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        b4Layout.setVerticalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(b4, new java.awt.GridBagConstraints());

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        csharp4.setBackground(new java.awt.Color(0, 0, 0));
        csharp4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout csharp4Layout = new javax.swing.GroupLayout(csharp4);
        csharp4.setLayout(csharp4Layout);
        csharp4Layout.setHorizontalGroup(
            csharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        csharp4Layout.setVerticalGroup(
            csharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(csharp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        c4Layout.setVerticalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c4Layout.createSequentialGroup()
                .addComponent(csharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(c4, new java.awt.GridBagConstraints());

        d4.setBackground(new java.awt.Color(255, 255, 255));
        d4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dsharp4.setBackground(new java.awt.Color(0, 0, 0));
        dsharp4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout dsharp4Layout = new javax.swing.GroupLayout(dsharp4);
        dsharp4.setLayout(dsharp4Layout);
        dsharp4Layout.setHorizontalGroup(
            dsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        dsharp4Layout.setVerticalGroup(
            dsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d4Layout = new javax.swing.GroupLayout(d4);
        d4.setLayout(d4Layout);
        d4Layout.setHorizontalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsharp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d4Layout.setVerticalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d4Layout.createSequentialGroup()
                .addComponent(dsharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(d4, new java.awt.GridBagConstraints());

        e4.setBackground(new java.awt.Color(255, 255, 255));
        e4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout e4Layout = new javax.swing.GroupLayout(e4);
        e4.setLayout(e4Layout);
        e4Layout.setHorizontalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        e4Layout.setVerticalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(e4, new java.awt.GridBagConstraints());

        f4.setBackground(new java.awt.Color(255, 255, 255));
        f4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fsharp4.setBackground(new java.awt.Color(0, 0, 0));
        fsharp4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout fsharp4Layout = new javax.swing.GroupLayout(fsharp4);
        fsharp4.setLayout(fsharp4Layout);
        fsharp4Layout.setHorizontalGroup(
            fsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        fsharp4Layout.setVerticalGroup(
            fsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout f4Layout = new javax.swing.GroupLayout(f4);
        f4.setLayout(f4Layout);
        f4Layout.setHorizontalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fsharp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        f4Layout.setVerticalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f4Layout.createSequentialGroup()
                .addComponent(fsharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(f4, new java.awt.GridBagConstraints());

        g4.setBackground(new java.awt.Color(255, 255, 255));
        g4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        gsharp4.setBackground(new java.awt.Color(0, 0, 0));
        gsharp4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout gsharp4Layout = new javax.swing.GroupLayout(gsharp4);
        gsharp4.setLayout(gsharp4Layout);
        gsharp4Layout.setHorizontalGroup(
            gsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        gsharp4Layout.setVerticalGroup(
            gsharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout g4Layout = new javax.swing.GroupLayout(g4);
        g4.setLayout(g4Layout);
        g4Layout.setHorizontalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gsharp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        g4Layout.setVerticalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g4Layout.createSequentialGroup()
                .addComponent(gsharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(g4, new java.awt.GridBagConstraints());

        a4.setBackground(new java.awt.Color(255, 255, 255));
        a4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        asharp4.setBackground(new java.awt.Color(0, 0, 0));
        asharp4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout asharp4Layout = new javax.swing.GroupLayout(asharp4);
        asharp4.setLayout(asharp4Layout);
        asharp4Layout.setHorizontalGroup(
            asharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        asharp4Layout.setVerticalGroup(
            asharp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout a4Layout = new javax.swing.GroupLayout(a4);
        a4.setLayout(a4Layout);
        a4Layout.setHorizontalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asharp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        a4Layout.setVerticalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a4Layout.createSequentialGroup()
                .addComponent(asharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(a4, new java.awt.GridBagConstraints());

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
        b5.setLayout(b5Layout);
        b5Layout.setHorizontalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        b5Layout.setVerticalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(b5, new java.awt.GridBagConstraints());

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        csharp5.setBackground(new java.awt.Color(0, 0, 0));
        csharp5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout csharp5Layout = new javax.swing.GroupLayout(csharp5);
        csharp5.setLayout(csharp5Layout);
        csharp5Layout.setHorizontalGroup(
            csharp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        csharp5Layout.setVerticalGroup(
            csharp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(csharp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        c5Layout.setVerticalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c5Layout.createSequentialGroup()
                .addComponent(csharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(c5, new java.awt.GridBagConstraints());

        d5.setBackground(new java.awt.Color(255, 255, 255));
        d5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dsharp5.setBackground(new java.awt.Color(0, 0, 0));
        dsharp5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout dsharp5Layout = new javax.swing.GroupLayout(dsharp5);
        dsharp5.setLayout(dsharp5Layout);
        dsharp5Layout.setHorizontalGroup(
            dsharp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        dsharp5Layout.setVerticalGroup(
            dsharp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
        d5.setLayout(d5Layout);
        d5Layout.setHorizontalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsharp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d5Layout.setVerticalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d5Layout.createSequentialGroup()
                .addComponent(dsharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pianoPane.add(d5, new java.awt.GridBagConstraints());

        e5.setBackground(new java.awt.Color(255, 255, 255));
        e5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
        e5.setLayout(e5Layout);
        e5Layout.setHorizontalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        e5Layout.setVerticalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        pianoPane.add(e5, new java.awt.GridBagConstraints());

    }
    
    private Piano model;
}
