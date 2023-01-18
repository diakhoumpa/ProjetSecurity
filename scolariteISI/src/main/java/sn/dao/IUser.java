package sn.dao;

import sn.entities.User;

import java.util.List;

public interface IUser {
    public int save (User user);
    public int update (User user);
    public int remove (int id);
    public User get (int id);
    public List<User> getAll ();
}
