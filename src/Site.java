import observer.EmailNotification;
import observer.User;
import observer.UserObserver;
import observer.UserSubject;

public class Site {
    public static void main(String[] args) {
        // Criação do serviço de notificação por e-mail
        EmailNotification emailNotification = new EmailNotification();
        
        // Criação do observador que envia e-mails
        UserObserver emailObserver = (User newUser) -> {
            emailNotification.sendEmail("Novo usuário registrado: " + newUser.getName());
        };
        
        // Criação do sujeito que gerencia os usuários e observadores
        UserSubject userSubject = new UserSubject();
        userSubject.addObserver(emailObserver);
        
        // Registrando novos usuários
        User user1 = new User("Maria");
        User user2 = new User("João");
        
        userSubject.registerUser(user1);
        userSubject.registerUser(user2);
    }
}