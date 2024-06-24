package Leetcode;

import java.util.*;

public class Maximum_Meetings_in_One_Room {
    static class Meeting{
        int start;
        int end;
        int idx;

        Meeting(int start, int end, int idx){
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    static class MeetingComparator implements Comparator<Meeting>
    {
        @Override
        public int compare(Meeting o1, Meeting o2)
        {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if(o1.idx < o2.idx)
                return -1;
            return 1;
        }
    }


    static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meetings.add(new Meeting(S[N], F[N], i+1));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);

        res.add(meetings.get(0).idx);
        int prevEndTime = meetings.get(0).end;

        for (int i = 1; i < N; i++) {
            Meeting top = meetings.get(i);
            int curStart = top.start;
            int curEnd = top.end;
            int curIdx = top.idx;

            if (curStart > prevEndTime){
                res.add(curIdx);
                prevEndTime = curEnd;
            }
        }

        Collections.sort(res);
        return res;
    }
}
