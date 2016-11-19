/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author chance
 */
class LoginFrame {

    public LoginFrame(int actor) {
        switch (actor) {
            case 0:
                new CounterPersonFrame().setVisible(true);
                break;
            case 1:
                new ManagerGUI().setVisible(true);
                break;
            case 2:
                new AdminFrame().setVisible(true);
                break;
            default:
                break;
        }
    }

}
