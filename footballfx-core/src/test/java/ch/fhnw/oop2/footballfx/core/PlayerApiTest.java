package ch.fhnw.oop2.footballfx.core;

/*
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest(classes = { PlayerApi.class, PlayerService.class, PlayerRepository.class })
 * public class PlayerApiTest extends JpaTest {
 * 
 * @Inject
 * private PlayerApi playerApi;
 * 
 * @Test
 * public void retrieveAllPlayers() {
 * List<Player> players = playerApi.retrieveAllPlayers();
 * assertThat(players).isNotNull();
 * }
 * 
 * @Test
 * public void createPlayer() {
 * Player player = new Player();
 * player.setName("Hakuna");
 * Player expectedPlayer = playerApi.createPlayer(player);
 * 
 * List<Player> actualPlayers = playerApi.retrieveAllPlayers();
 * assertThat(actualPlayers).contains(expectedPlayer);
 * }
 * 
 * @Test(expected = InvalidDataAccessApiUsageException.class)
 * public void failCreatePlayerNull() {
 * playerApi.createPlayer(null);
 * }
 * 
 * @Test
 * public void deletePlayer() {
 * List<Player> players = playerApi.retrieveAllPlayers();
 * Player expectedPlayer = players.get(0);
 * playerApi.deletePlayer(expectedPlayer.getId());
 * 
 * List<Player> actualPlayers = playerApi.retrieveAllPlayers();
 * assertThat(actualPlayers).doesNotContain(expectedPlayer);
 * }
 * 
 * @Test(expected = InvalidDataAccessApiUsageException.class)
 * public void failDeletePlayerNull() {
 * playerApi.deletePlayer(null);
 * }
 * 
 * @Test
 * public void updatePlayer() {
 * Player expectedPlayer = playerApi.retrieveAllPlayers().get(0);
 * expectedPlayer.setName("Hakuna");
 * 
 * playerApi.updatePlayer(expectedPlayer.getId(), expectedPlayer);
 * 
 * List<Player> actualPlayers = playerApi.retrieveAllPlayers();
 * assertThat(actualPlayers).contains(expectedPlayer);
 * }
 * 
 * @Test(expected = NullPointerException.class)
 * public void failUpdatePlayerAndIdNull() {
 * playerApi.updatePlayer(null, null);
 * }
 * 
 * @Test(expected = NullPointerException.class)
 * public void failUpdatePlayerNullId() {
 * Player player = playerApi.retrieveAllPlayers().get(0);
 * playerApi.updatePlayer(null, player);
 * }
 * 
 * @Test(expected = NullPointerException.class)
 * public void failUpdatePlayerNullPlayer() {
 * playerApi.updatePlayer(UUID.randomUUID(), null);
 * }
 * }
 */