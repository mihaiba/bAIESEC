package com.levi9.rest.TestRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.TestRest.memoryDB.Database;
import com.levi9.rest.TestRest.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = Database.getProfiles();

	public ProfileService() {
		profiles.put("mihai", new Profile(1, "mihai", "mihai", "balaniscu"));
		profiles.put("albert", new Profile(2, "albert", "albert", "chmilevski"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		Profile oldProfile = profiles.get(profile.getProfileName());
		profile.setId(oldProfile.getId());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
