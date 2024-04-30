
import { useEffect, useState } from 'react'

import { Link, useLocation, useNavigate } from 'react-router-dom'

import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import TextField from '@mui/material/TextField';

import axios from 'axios';

import * as EgovNet from 'api/egovFetch'
import { NOTICE_BBS_ID } from 'config'
import CODE from 'constants/code'
import URL from 'constants/url'

import EgovAttachFile from 'components/EgovAttachFile'
import { default as EgovLeftNav } from 'components/leftmenu/EgovLeftNavInform'

function EgovNoticeDetail(props) {
    console.group("EgovNoticeDetail");
    console.log("EgovNoticeDetail [props] : ", props);

    const navigate = useNavigate();
    const location = useLocation();
    console.log("EgovNoticeDetail [location] : ", location);

    // const bbsId = location.state.bbsId || NOTICE_BBS_ID;
    const name = location.state.name;
    const searchCondition = location.state.searchCondition;

    const [updateMinwonType2open, setUpdateMinwonType2Open] = useState(false);
    const condition = true; 

    const [entity, setEntity] = useState("");

    const [masterBoard, setMasterBoard] = useState({});
    const [user, setUser] = useState({});
    const [boardDetail, setBoardDetail] = useState({});
    const [boardAttachFiles, setBoardAttachFiles] = useState();

    const retrieveDetail = () => {
        const retrieveDetailURL = `/minwonType2s/${name}`;
        const requestOptions = {
            method: "GET",
            headers: {
                'Content-type': 'application/json'
            }
        }
        EgovNet.requestFetch(retrieveDetailURL,
            requestOptions,
            function (resp) {
                setBoardDetail(resp);
            }
        );
    }
    useEffect(function () {
        retrieveDetail();
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    function deleteList(){
        axios.delete(`/minwonType2s/${name}`)
        navigate('/process2/minwonType2s');
    }
    function updateMinwonType2(){

        axios.put(`/orders/${name}/acceptorder`, {name: entity }) 
        .then(response => {
            // setUpdateMinwonType2Open(false);
        })
    }

    return (
        <div className="container">
            <div className="c_wrap">
                {/* <!-- Location --> */}
                <div className="location">
                    <ul>
                        <li><Link to={URL.MAIN} className="home">Home</Link></li>
                        <li><Link to="/process2/minwonType2s">MinwonType2</Link></li>
                        <li>{masterBoard && masterBoard.bbsNm}</li>
                    </ul>
                </div>
                {/* <!--// Location --> */}

                <div className="layout">
                    {/* <!-- Navigation --> */}
                    <EgovLeftNav></EgovLeftNav>
                    {/* <!--// Navigation --> */}

                    <div className="contents NOTICE_VIEW" id="contents">
                        {/* <!-- 본문 --> */}

                        <div className="top_tit">
                            <h1 className="tit_1">MinwonType2</h1>
                        </div>

                        {/* <!-- 게시판 상세보기 --> */}
                        <div className="board_view">
                            <div className="board_view_top">
                                <div className="tit">{name}</div>
                                <div className="info">
                                    <dl>
                                        <dt>Name</dt>
                                        <dd>{name}</dd>
                                    </dl>
                                    <dl>
                                        <dt>Description</dt>
                                        <dd>{boardDetail && boardDetail.description }</dd>
                                    </dl>
                                </div>
                            </div>
                            <div className="board_btn_area">
                                <div style={{ display: "flex", flexDirection: "row"}}>
                                    <div style={{marginTop: "5px"}}>
                                        <button className="btn btn_blue_h46 w_100"
                                         onClick={() => {
                                            if (condition) {  
                                            setUpdateMinwonType2Open(true);
                                            }
                                        }}>
                                            UpdateMinwonType2
                                        </button>
                                    </div>
                                </div>
                                <div className="right_col btn1" style={{marginTop: "5px"}}>
                                    <Link to="/process2/minwonType2s"
                                        className="btn btn_blue_h46 w_100">목록</Link>
                                </div>
                                <div className="right_col btn1" style={{marginTop: "5px", marginRight: "9%"}}>
                                    <button
                                        onClick={deleteList}
                                        className="btn btn_blue_h46 w_100">삭제
                                    </button>
                                </div>
                            </div>
                        </div>
                        {/* <!-- 게시판 상세보기 --> */}
                        <div>
                            <Dialog open={updateMinwonType2open} onClose={() => setUpdateMinwonType2Open(false)}>
                                <DialogTitle>UpdateMinwonType2</DialogTitle>
                                <DialogContent>
                                    <TextField 
                                        autoFocus
                                        margin="dense"
                                        id=""
                                        label=""
                                        type="text"
                                        fullWidth
                                        value={entity}
                                        onChange={(e) => setEntity(e.target.value)}
                                    />
                                </DialogContent>
                                <DialogActions>
                                    <button onClick={() => setUpdateMinwonType2Open(false)} className="btn btn_blue_h46 w_100">
                                        Cancel
                                    </button>
                                    <button onClick={updateMinwonType2} className="btn btn_blue_h46 w_100">
                                    UpdateMinwonType2
                                    </button>
                                </DialogActions>
                            </Dialog>
                        </div>
                        
                        {/* <!--// 본문 --> */}
                    </div>
                </div>
            </div>
        </div>
    );
}


export default EgovNoticeDetail;
