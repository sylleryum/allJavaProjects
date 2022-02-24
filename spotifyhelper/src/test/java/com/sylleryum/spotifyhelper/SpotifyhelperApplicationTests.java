package com.sylleryum.spotifyhelper;

import com.sylleryum.spotifyhelper.config.Endpoints;
import com.sylleryum.spotifyhelper.config.SpotifyCredentials;
import com.sylleryum.spotifyhelper.model.AccessToken;
import com.sylleryum.spotifyhelper.model.jsonResponses.UserPlaylists;
import com.sylleryum.spotifyhelper.service.ServiceApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpotifyhelperApplicationTests {

    @Autowired
    SpotifyCredentials spotifyCredentials;
    @Autowired
    Endpoints endpoints;
    @Autowired
    ServiceApi serviceApi;

    /*unavailable
    0OYGSvSFCW5NZEvn2svFLS*/
    /*fav
    5Bo3G9pauPpd0oSPPTVufY*/
    /*
    https://accounts.spotify.com/authorize?client_id=ee81813e9b884f6cacdb265e6c6ebd40&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fapi%2Fv1%2Fcallback&scope=user-read-private%20user-read-email%20playlist-read-private%20playlist-modify-public%20playlist-modify-private
    */
    @Test
    void contextLoads() throws Exception {
        AccessToken accessToken = serviceApi.setRefresh("AQAIjS_tX0ug68qifQ2cuXCBxDmVsuq-AqajNV8zi7MIp63koCvbV0yu2HFtcy56GRzCFk2FXHSCCBYo2PQy2E1MTupOb_KZKht1yUh92oL3HTzgo7nrtYJCwbzHYOutwZY");
        List<UserPlaylists> playlists = serviceApi.getPlaylists(accessToken);
        System.out.println();

    }


    @Test
    void theTest() {
        int[] alist = new int[]{3, 6, 9, 1, 4, 10, 5};
        quickSort(alist, 0, alist.length - 1);
        System.out.println();
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
