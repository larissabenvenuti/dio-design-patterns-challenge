package observer;

import java.util.ArrayList;
import java.util.List;

public class UserSubject {
    private final List<UserObserver> observers = new ArrayList<>();
    
    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(User newUser) {
        for (UserObserver observer : observers) {
            observer.update(newUser);
        }
    }
    
    public void registerUser(User user) {
        // Aqui você pode adicionar a lógica para salvar o usuário
        System.out.println("Novo usuário registrado: " + user.getName());
        notifyObservers(user);
    }
}