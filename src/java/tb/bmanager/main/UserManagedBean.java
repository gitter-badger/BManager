/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb.bmanager.main;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import tb.bmanager.entity.UserEntity;
import tb.bmanager.entitymanager.UserEntityFacade;

/**
 * Controller for the user view.
 * 
 * @author oskarmendel
 * @version 0.00.00
 * %name UserManagedBean.java
 * %date 15:35:10 PM, Jun 15, 2016
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {
    
    @EJB
    private UserEntityFacade userFacade;
    
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String bio;
    private String websiteurl;
    private int followers;
    private int follows;
    private int projects;
    private UserEntity user;
    
    private int userId;
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    public void init() {

        user = userFacade.find(userId);

        if (user == null) {
            String message = "Bad request. Unknown user.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
    
    /**
     * Uses the UserEntityFacade to return all user records.
     * @return 
     */
    public List<UserEntity> getAll(){
        return userFacade.findAll();
    }
    
    /**
     * Uses the UserEntityFacade to return the user with specified id.
     * @param id - id of target user.
     * @return the UserEntity of found user.
     */
    public UserEntity getById(int id){
        return userFacade.find(id);
    }
    
    /**
     * Uses the UserEntityFacade to return the amount user records.
     * @return 
     */
    public int count() {
        return userFacade.count();
    }
    
    /**
     * Uses the UserEntityFacade to delete specified user record.
     * 
     * @param u - Target user record to be deleted.
     * @return - null
     */
    public String delete(UserEntity u) {
        userFacade.remove(u);
        return null; //Error logging ?
    }
    
    /**
     * 
     * @param u - user object.
     */
    public void setUser(UserEntity u) {
        this.user = u;
    }
    
    /**
     * 
     * @return the user object.
     */
    public UserEntity getUser(){
        return this.user;
    }
    
    /**
     * 
     * @return the user id of the local user object.
     */
     public int getUserId() {
        return userId;
    }

     /**
      * 
      * @param userId - the user id of the local user object.
      */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void agg(){
        System.out.println("worked");
    }
}
