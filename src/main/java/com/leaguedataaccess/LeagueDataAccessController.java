package com.leaguedataaccess;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leaguedataaccess.jdbc.MessageBoardDAO;
import com.leaguedataaccess.jdbc.OwnerDAO;
import com.leaguedataaccess.jdbc.StatsDAO;
import com.leaguedataaccess.model.MessageBoardPost;
import com.leaguedataaccess.model.Owner;
import com.leaguedataaccess.model.OwnerStats;
import com.leaguedataaccess.authentication.UnauthorizedException;
import com.leaguedataaccess.authentication.AuthProvider;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LeagueDataAccessController {

	private OwnerDAO ownerDAO;
	private StatsDAO statsDAO;
	private MessageBoardDAO messageBoardDAO;
	
	@Autowired
    private AuthProvider authProvider;
	
	@Autowired
	public LeagueDataAccessController(OwnerDAO ownerDAO, StatsDAO statsDAO, MessageBoardDAO messageBoardDAO) {
		this.ownerDAO = ownerDAO;
		this.statsDAO = statsDAO;
		this.messageBoardDAO = messageBoardDAO;
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
        if (!authProvider.userHasRole(new String[] { "admin"})) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
	
	@GetMapping("/owners")
	public List<Owner> getListOfAllOwners() {
		return ownerDAO.getAllOwners();
	}
	
	@GetMapping("/stats/{id}")
	public OwnerStats getOwnerStats(@PathVariable int id) {
		Owner owner = ownerDAO.getOwnerById(id);
		OwnerStats stats = statsDAO.getTotalStatsForOneOwner(owner);
		return stats;
	}
	
	@GetMapping("/totalstats")
	public List<OwnerStats> getAllOwnerStats() {
		List<Owner> listOfAllOwners = ownerDAO.getAllOwners();
		List<OwnerStats> listOfAllOwnerStats = new LinkedList<OwnerStats>();
		for (Owner owner : listOfAllOwners) {
			listOfAllOwnerStats.add(statsDAO.getTotalStatsForOneOwner(owner));
		}
		return listOfAllOwnerStats;
	}
	
	@GetMapping(path="/h2hstats/{idOne}/{idTwo}")
	public OwnerStats getHeadToHeadStats(@PathVariable int idOne,@PathVariable int idTwo) {
		Owner one = ownerDAO.getOwnerById(idOne);
		Owner two = ownerDAO.getOwnerById(idTwo);
		return statsDAO.getHeadToHeadStats(one, two);
	}
	
	@GetMapping("/boardposts")
	public List<MessageBoardPost> getAllPosts() {
		return messageBoardDAO.getAllPosts();
	}
	
	@PostMapping("/boardposts")
	@ResponseStatus(HttpStatus.CREATED)
	public MessageBoardPost newPost(@RequestBody MessageBoardPost newPost) {
		return messageBoardDAO.createNewPost(newPost);
	}
	
	@DeleteMapping("/boardposts/{id}")
	public void deletePost(@PathVariable int id) {
		MessageBoardPost requestedPost = messageBoardDAO.getPostById(id);
		messageBoardDAO.deletePost(id);
	}
}
