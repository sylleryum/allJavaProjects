package com.sylleryum.spotifyhelper;

import com.sylleryum.spotifyhelper.config.Endpoints;
import com.sylleryum.spotifyhelper.config.SpotifyCredentials;
import com.sylleryum.spotifyhelper.model.AccessToken;
import com.sylleryum.spotifyhelper.model.jsonResponses.UserPlaylists;
import com.sylleryum.spotifyhelper.service.ServiceApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        int[] ints = twoSum(new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997},
                542);
//        int[] ints = twoSum(new int[]{1,2,3,4,4,9,56,90},
//                8);
        System.out.println();
    }

    public int[] twoSum(int[] numbers, int target) {
        int pivot1 = 0, pivot2 = 0;
        int difference = target-numbers[pivot1];
        int left = 0, right = numbers.length - 1;

        try {
            while (pivot1<numbers.length-1) {
                while (left <= right) {
                    pivot2 = left + (right - left) / 2;
                    if (numbers[pivot2] == difference) return new int[]{pivot1+1, pivot2+1};
                    if (difference < numbers[pivot2]) right = pivot2 - 1;
                    else left = pivot2 + 1;
                }
                pivot1++;
                difference=target-numbers[pivot1];
                left = pivot1+1;
                right = numbers.length - 1;
            }
        }catch (Exception e){
            System.out.println();
        }


        return null;
    }


}
