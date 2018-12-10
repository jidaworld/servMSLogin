package BusinessLayer.Handlers;

import DataLayer.DBHandler.DBHandler;

public class UserHandler {

    private DBHandler DBHandler = new DBHandler();

    public UserHandler() {
    }

    public boolean Login(String username, String password) {
        return DBHandler.loginUser(username, password);
    }
}
