package sn.dao;

import sn.entities.Role;

import java.util.List;

public interface IRole {
    public int save (Role role);
    public int update (Role role);
    public int remove (int id);
    public Role get (int id);
    public List<Role> getAll ();
}
