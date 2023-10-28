package vn.edu.iuh.fit.ongiuaky_www.backend.services;

import vn.edu.iuh.fit.ongiuaky_www.backend.models.Experience;
import vn.edu.iuh.fit.ongiuaky_www.backend.repositories.ExperienceRepository;

import java.util.List;

public class ExperienceServices {
    private final ExperienceRepository experienceRepository;

    public ExperienceServices() {
        experienceRepository = new ExperienceRepository();
    }

    public List<Experience> findAllExperienceFromCanId(long canId) {
        return experienceRepository.findAllExperienceFromCanId(canId);
    }
}
