package com.example.userService.service;

import com.example.userService.domain.Address;
import com.example.userService.domain.Favourites;
import com.example.userService.domain.User;
import com.example.userService.domain.UserDto;
import com.example.userService.exception.FavouriteItemNotFoundException;
import com.example.userService.exception.UserNotFoundException;
import com.example.userService.proxy.UserProxy;
import com.example.userService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final UserProxy userProxy;

    @Autowired
    public UserService(UserRepo userRepo, UserProxy userProxy) {
        this.userRepo = userRepo;
        this.userProxy = userProxy;
    }

    @Override
    public User addUser(User user) {

        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole());
        userDto.setPhoneNo(user.getPhoneNo());
        userDto.setImageName(user.getImageName());
        System.out.println(userDto);
        userProxy.registerUser(userDto);

        return userRepo.save(user);

    }

    @Override
    public User addFavouritesInList(String email, Favourites favourites){

        User user = userRepo.findById(email).get();

        boolean alreadyExist = false;
        if (user.getListFavourites() != null) {
            for (Favourites list : user.getListFavourites()) {
                if (list.getItemName().equals(favourites.getItemName())) {
                    alreadyExist = true;
                    break;
                }
            }
        }
        if (!alreadyExist) {
            if (user.getListFavourites() == null) {
                user.setListFavourites(new ArrayList<>());

            }
            user.getListFavourites().add(favourites);
        }
        userRepo.save(user);
        return user;
    }

    // update user info
    @Override
    public User updateUser(String email, User updatedUser) throws UserNotFoundException {
        if(userRepo.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User existingUser = userRepo.findById(email).get();
        UserDto userDto = new UserDto();

        if(updatedUser.getProfileImg() !=null){
            existingUser.setProfileImg(updatedUser.getProfileImg());
        }

        if(updatedUser.getName() != null){
            existingUser.setName(updatedUser.getName());
            userDto.setName(updatedUser.getName());
        }
        if(updatedUser.getPhoneNo() != 0){
            existingUser.setPhoneNo(updatedUser.getPhoneNo());
            userDto.setPhoneNo(updatedUser.getPhoneNo());
        }
        if(updatedUser.getImageName()!=null){
            existingUser.setImageName(updatedUser.getImageName());
            userDto.setImageName(updatedUser.getImageName());
        }
        userProxy.updateUser(userDto,email);
        return userRepo.save(existingUser);
    }

    // user's favourite cuisine list
    @Override
    public List<Favourites> getListOfFavouriteById(String email) throws FavouriteItemNotFoundException {
        if(userRepo.findById(email).isEmpty()){
            throw new FavouriteItemNotFoundException();
        }

        User user = userRepo.findById(email).get();
        System.out.println(user.getListFavourites());
        return user.getListFavourites();
    }

    @Override
    public void removeFavouriteById(String email,int itemId) throws FavouriteItemNotFoundException{
        if(userRepo.findById(email).isEmpty()){
            throw new FavouriteItemNotFoundException();
        }
        User user = userRepo.findById(email).get();
        List<Favourites> listOfFav = user.getListFavourites();
        for(Favourites list :listOfFav) {
            if (list.getItemId() == itemId) {
                listOfFav.remove(list);
                System.out.println("Removed successfully....");
                userRepo.save(user);
                break;
            }
        }
    }

    @Override
    public boolean favItemExist(String email, int itemId) {
        List<Favourites> favList = userRepo.findById(email).get().getListFavourites();
        for(Favourites list: favList){
            if(list.getItemId()==itemId){
                return true;
            }
        }

        return false;
    }

    @Override
    public byte[] getUserProfileImg(String email) {
        User user = userRepo.findById(email).get();
        if(user.getEmail()!=null){
            return user.getProfileImg();
        }
        else {
            return null;
        }
    }

    @Override
    public User getUserName(String email) {
        User user  = userRepo.findById(email).get();
        if(user.getEmail().equals(email)){
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean addAddress(String email, Address address){
        Optional<User> userOptional = userRepo.findById(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setAddress(address);
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Address getAddress(String email){
        Optional<User> user=userRepo.findById(email);
        if (user.isPresent()){
            Address a=user.get().getAddress();
            return a;
        }else {
            return null;
        }
    }

}