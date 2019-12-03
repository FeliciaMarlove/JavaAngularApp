package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaysEntity;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.PaysRepository;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImplemented implements UtilisateurService {
    private UtilisateurRepository repo;
    private PaysRepository paysRepo;

    @Autowired
    public UtilisateurServiceImplemented(UtilisateurRepository repo, PaysRepository paysRepo) {
        this.repo = repo;
        this.paysRepo = paysRepo;
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
    public void creerCompte(UtilisateurEntity nouvelUtilisateur) {
        boolean isDuplicate = false;
        List<UtilisateurEntity> utilisateursExistants = findAll();
        for (int i = 0; i < utilisateursExistants.size(); i++) {
            if (nouvelUtilisateur.equals(utilisateursExistants.get(i))) {
                isDuplicate = true;
            }
        }
        if(!isDuplicate) {
            //nouvelUtilisateur.setActiveUtilisateur(true);
            repo.save(nouvelUtilisateur);
        }
    }

    @Override
    public void majUtilisateur(UtilisateurEntityDto utilisateur, Long id) {
        UtilisateurEntity u = repo.findById(id).get();
        u.setEmail(utilisateur.getEmail());
        u.setMotDePasse(utilisateur.getMotDePasse());
        PaysEntity p = paysRepo.findById(utilisateur.getIdPays()).get();
        u.setPays(p);
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

    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDetails> userOptional = this.repo.findByEmail(s);
        if (userOptional.isPresent()) return userOptional.get();
        throw new UsernameNotFoundException(s);
    }*/
}
