package ac.ucr.c01880.dotwarsprojectclient.presentation;

import javax.swing.JFrame;

public class JFWindowPageSelect extends JFrame{

	
	
    public JFWindowPageSelect() {
        initComponents();
    }

    
    private void initComponents() {

        tfPlayerName = new javax.swing.JTextField();
        jbCreate = new javax.swing.JButton();
        tfMatrixSize = new javax.swing.JTextField();
        jbJoin = new javax.swing.JButton();
        jbNext = new javax.swing.JButton();
        tfPassword2 = new javax.swing.JTextField();
        tfPassword1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfPlayerName.setText("Insert Player");

        jbCreate.setText("Create");
        jbCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateActionPerformed(evt);
            }
        });

        tfMatrixSize.setText("Size matrix");
        tfMatrixSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMatrixSizeActionPerformed(evt);
            }
        });

        jbJoin.setText("Join");

        jbNext.setText("Next");

        tfPassword2.setText("Password");

        tfPassword1.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMatrixSize, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addComponent(tfPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(tfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCreate)
                    .addComponent(jbJoin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(tfMatrixSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbNext)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCreateActionPerformed

    private void tfMatrixSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMatrixSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMatrixSizeActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCreate;
    private javax.swing.JButton jbJoin;
    private javax.swing.JButton jbNext;
    private javax.swing.JTextField tfMatrixSize;
    private javax.swing.JTextField tfPassword1;
    private javax.swing.JTextField tfPassword2;
    private javax.swing.JTextField tfPlayerName;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getJbCreate() {
		return jbCreate;
	}

	public void setJbCreate(javax.swing.JButton jbCreate) {
		this.jbCreate = jbCreate;
	}

	public javax.swing.JButton getJbJoin() {
		return jbJoin;
	}

	public void setJbJoin(javax.swing.JButton jbJoin) {
		this.jbJoin = jbJoin;
	}

	public javax.swing.JButton getJbNext() {
		return jbNext;
	}

	public void setJbNext(javax.swing.JButton jbNext) {
		this.jbNext = jbNext;
	}

	public javax.swing.JTextField getTfMatrixSize() {
		return tfMatrixSize;
	}

	public void setTfMatrixSize(javax.swing.JTextField tfMatrixSize) {
		this.tfMatrixSize = tfMatrixSize;
	}

	public javax.swing.JTextField getTfPassword1() {
		return tfPassword1;
	}

	public void setTfPassword1(javax.swing.JTextField tfPassword1) {
		this.tfPassword1 = tfPassword1;
	}

	public javax.swing.JTextField getTfPassword2() {
		return tfPassword2;
	}

	public void setTfPassword2(javax.swing.JTextField tfPassword2) {
		this.tfPassword2 = tfPassword2;
	}

	public javax.swing.JTextField getTfPlayerName() {
		return tfPlayerName;
	}

	public void setTfPlayerName(javax.swing.JTextField tfPlayerName) {
		this.tfPlayerName = tfPlayerName;
	}
    
    
}
