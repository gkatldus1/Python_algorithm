import datetime
def solution(m, musicinfos):
    answer = None
    m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
    for music in musicinfos:
        music = music.split(",")
        music[3] = music[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
        start = datetime.datetime.strptime(music[0], "%M:%S").timestamp()
        end = datetime.datetime.strptime(music[1], "%M:%S").timestamp()
        play = int(end - start)
        l, n = divmod(play, len(music[3]))
        sound = music[3]*l +"".join([music[3][i] for i in range(n) ])

        if m not in sound:
            continue

        if answer == None or play > answer[1]:
                answer = (music[2], play)
                
    if answer:
        return answer[0]
                
    return "(None)"