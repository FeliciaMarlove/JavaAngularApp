package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.RoleEntity;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.PaysRepository;
import be.technofuturtic.javaangularapp.repositories.RoleRepository;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import be.technofuturtic.javaangularapp.utilitaires.AuthentificationDto;
import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurServiceImplemented implements UtilisateurService {
    private UtilisateurRepository repo;
    private PaysRepository paysRepo;
    private RoleRepository roleRepository;

    @Autowired
    public UtilisateurServiceImplemented(UtilisateurRepository repo, PaysRepository paysRepo, RoleRepository roleRepository) {
        this.repo = repo;
        this.paysRepo = paysRepo;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UtilisateurEntity> findAll() {
        return (List<UtilisateurEntity>) repo.findAll();
    }

    @Override
    public void desactiverUtilisateur(Long idUtilisateur) {
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setActiveUtilisateur(false);
        repo.save(u);
    }

    @Override
    public void activerUtilisateur(Long idUtilisateur) {
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setActiveUtilisateur(true);
        repo.save(u);
    }

    @Override
    public Boolean creerCompte(UtilisateurEntityDto nouvelUtilisateur) {
        boolean isDuplicate = false;
        UtilisateurEntity newbie = new UtilisateurEntity(
                nouvelUtilisateur.getNomUtilisateur(),
                nouvelUtilisateur.getPrenomUtilisateur(),
                nouvelUtilisateur.getEmail(),
                nouvelUtilisateur.getMotDePasse(),
                /*nouvelUtilisateur.getNewsletterOptIn(),*/
                false,
                true,
                false
        );
        newbie.setDateNaiss(nouvelUtilisateur.getDateNaiss()); //formatage string > date
        List<UtilisateurEntity> utilisateursExistants = findAll();
        for (int i = 0; i < utilisateursExistants.size(); i++) {
            if (newbie.equals(utilisateursExistants.get(i))) {
                isDuplicate = true;
            }
        }
        if(!isDuplicate) {
            newbie.setActiveUtilisateur(true);
            RoleEntity role = roleRepository.findById(1).get();
            newbie.setRole(role); // set à "user" par défaut
            repo.save(newbie);
        }
        return isDuplicate;
    }

    @Override
    public void majUtilisateur(UtilisateurEntityDto utilisateur, Long id) {
        UtilisateurEntity u = repo.findById(id).get();
        u.setEmail(utilisateur.getEmail());
        u.setMotDePasse(utilisateur.getMotDePasse());
        /*PaysEntity p = paysRepo.findById(utilisateur.getPaysId()).get();
        u.setPays(p);*/
        repo.save(u);
    }

    @Override
    public void inscrireNewsletter(Long idUtilisateur) {
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setNewsletterOptIn(true);
        repo.save(u);
    }

    @Override
    public void desinscrireNewsletter(Long idUtilisateur) {
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setNewsletterOptIn(false);
        repo.save(u);
    }

    @Override
    public Boolean login(AuthentificationDto logins) {
        boolean authorize = false;
        StringBuilder msg = new StringBuilder();
        String message = "";
        String passwordFromCurrentTryingUser = null;
        List<UtilisateurEntity> toutLeMonde = (List<UtilisateurEntity>) repo.findAll();
        List<AuthentificationDto> tousLesIdentifiants = new ArrayList<>();
        for (int i = 0; i < toutLeMonde.size(); i++) {
            tousLesIdentifiants.add(new AuthentificationDto(toutLeMonde.get(i).getEmail(), toutLeMonde.get(i).getMotDePasse()));
        }
        for (int i = 0; i < tousLesIdentifiants.size(); i++) {
            if (tousLesIdentifiants.get(i).getEmail().equals(logins.getEmail())) {
                msg.append("Email address registered");
                passwordFromCurrentTryingUser = tousLesIdentifiants.get(i).getPassword();
                if (passwordFromCurrentTryingUser.equals(logins.getPassword())) {
                    msg.append("\tLogin accepted");
                    authorize = true;
                } else {
                    msg.append("\tWrong password");
                }
            } else {
                message = "Email not found";
            }
        }
        message = msg.toString();
        System.out.println(message);
        return authorize;
    }

    @Override
    public UtilisateurEntityDto findByEmail(String email) {
        UtilisateurEntity u = repo.findByEmail(email);
        UtilisateurEntityDto lElu = new UtilisateurEntityDto(
            u.getNomUtilisateur(), u.getPrenomUtilisateur(), u.getDateNaiss(), u.getEmail(), u.getMotDePasse(), u.isNewsletterOptIn(), u.getRole().getIdRole(), u.getBusy()
        );
        lElu.setIdUtilisateur(u.getIdUtilisateur());
        return lElu;
    }

    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDetails> userOptional = this.repo.findByEmail(s);
        if (userOptional.isPresent()) return userOptional.get();
        throw new UsernameNotFoundException(s);
    }*/
}
