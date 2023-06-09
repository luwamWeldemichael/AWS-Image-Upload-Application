package springreactaws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springreactaws.profile.UserProfile;
import springreactaws.service.UserProfileService;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfile() {
        return null;
    }

    @PostMapping(
            path = "/{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable UUID userProfileId,
                                       @RequestParam MultipartFile file) {
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }
    @GetMapping("/{userProfileId}/image/download")
    public byte[] downloadProfileImage(@PathVariable UUID userProfileId){
        return userProfileService.downloadProfileImage(userProfileId);
    }
}
