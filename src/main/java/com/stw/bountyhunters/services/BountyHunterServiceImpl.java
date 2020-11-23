package com.stw.bountyhunters.services;

import com.stw.bountyhunters.model.BountyHunter;
import com.stw.bountyhunters.repositories.BountyHunterRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BountyHunterServiceImpl implements BountyHunterService {

    private final BountyHunterRepository bountyHunterRepository;

    public BountyHunterServiceImpl(BountyHunterRepository bountyHunterRepository) {
        this.bountyHunterRepository = bountyHunterRepository;
    }

    @Override
    public Set<BountyHunter> findAll() {
        Set<BountyHunter> hunters = new HashSet<>();
        bountyHunterRepository.findAll().forEach(hunters::add);
        return hunters;
    }

    @Override
    public BountyHunter findById(Long aLong) {
        return bountyHunterRepository.findById(aLong).orElse(null);
    }

    @Override
    public BountyHunter save(BountyHunter object) {
        return bountyHunterRepository.save(object);
    }

    @Override
    public void delete(BountyHunter object) {
        bountyHunterRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bountyHunterRepository.deleteById(aLong);
    }
}
