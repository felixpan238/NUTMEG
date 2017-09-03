package org.nutmegsoccer.nutmeg.player;

@RestController
public class PlayerRestService {


    @Autowired
    private PlayerService playerService;

    @RequestMapping(method= RequestMethod.GET, value="/player/search")
    public List<Player> searchPlayers() {
        return playerService.searchPlayer();
    }

    @RequestMapping(method= RequestMethod.GET, value="/player/{id}")
    public Player findById(@PathVariable int id) {
        return playerService.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/player")
    public void createPlayer(@RequestBody Player player) {
        playerService.insertPlayer(player);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/player")
    public void updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/player/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}
