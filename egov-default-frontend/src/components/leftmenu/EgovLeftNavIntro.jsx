import React from 'react';

import { NavLink } from 'react-router-dom';
import URL from 'constants/url';

function EgovLeftNavIntro() {

    const lastSegment = window.parent.location.href.split('/').pop();
    
    if (lastSegment === 'applications'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Application</h2>
                    <ul className="menu4">
                        <li><NavLink to="/application/applications" className={({ isActive }) => (isActive ? "cur" : "")}>Application</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'investigations'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Process1</h2>
                    <ul className="menu4">
                        <li><NavLink to="/process1/investigations" className={({ isActive }) => (isActive ? "cur" : "")}>Investigation</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'processings'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Process1</h2>
                    <ul className="menu4">
                        <li><NavLink to="/process1/processings" className={({ isActive }) => (isActive ? "cur" : "")}>Processing</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'minwonType2s'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Process2</h2>
                    <ul className="menu4">
                        <li><NavLink to="/process2/minwonType2s" className={({ isActive }) => (isActive ? "cur" : "")}>MinwonType2</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'rewardApplications'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Compensation</h2>
                    <ul className="menu4">
                        <li><NavLink to="/compensation/rewardApplications" className={({ isActive }) => (isActive ? "cur" : "")}>RewardApplication</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'compensationPayments'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Compensation</h2>
                    <ul className="menu4">
                        <li><NavLink to="/compensation/compensationPayments" className={({ isActive }) => (isActive ? "cur" : "")}>CompensationPayment</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'analysis1s'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Analysis1</h2>
                    <ul className="menu4">
                        <li><NavLink to="/analysis1/analysis1s" className={({ isActive }) => (isActive ? "cur" : "")}>Analysis1</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'analysis2s'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Analysis2</h2>
                    <ul className="menu4">
                        <li><NavLink to="/analysis2/analysis2s" className={({ isActive }) => (isActive ? "cur" : "")}>Analysis2</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    return null;
}

export default EgovLeftNavIntro;